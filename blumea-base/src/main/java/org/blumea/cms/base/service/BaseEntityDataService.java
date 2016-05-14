package org.blumea.cms.base.service;

import net.common.data.redis.IRedis;
import net.common.data.redis.client.BaseShardedJedisPipeline;
import org.blumea.cms.config.ServiceRedis;
import org.blumea.cms.dao.base.BaseDao;
import org.blumea.cms.entity.base.BaseEntity;
import org.blumea.cms.utils.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

/**
 * 基础的针对对象缓存的DataService (Cache + Dao)封装
 * <p/>
 * 只处理单个数据库对象的缓存
 */
public abstract class BaseEntityDataService<T extends BaseEntity> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseEntityDataService.class);

    @Resource
    protected ServiceRedis cacheService;

    private final String cacheServiceName;
    private final String cacheKey;
    private final int cacheTime;

    /**
     * 泛性的具体类型Class
     */
    private Class<T> entityClass;

    /**
     * 取得当前注入dal的抽象类
     */
    protected abstract BaseDao<T> getDao();

    /**
     * 获得关联子key
     */
    protected abstract String[] getSubKeys(T entity);

    public BaseEntityDataService(String cacheServiceName, String cacheKey, int cacheTime) {
        this.cacheServiceName = cacheServiceName;
        this.cacheKey = cacheKey;
        this.cacheTime = cacheTime;

        Class clazz = getClass();
        if (getClass().getName().contains("$EnhancerByGuice$")) {
            clazz = clazz.getSuperclass();
        }
        entityClass = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 添加T对象Service操作
     *
     * @param t 要添加的对象
     * @return 返回添加成功的T对象
     */
    public T add(T t) {
        getDao().save(t);
        if (null != t && t.getId() > 0) {
            this.setToCache(t);
            return t;
        }
        return null;
    }

    public T get(long id) {
        T t = this.getFromCache(id);
        if (t == null) {
            t = getDao().get(id);
            if (t != null && t.getId() > 0) {
                this.setToCache(t);
            }
        }
        return t;
    }

    public boolean update(T t) {
        boolean isSuccess = getDao().update(t);
        if (isSuccess) {
            this.setToCache(t);
        }
        return isSuccess;
    }

    public boolean delete(T t) {
        boolean isSuccess = getDao().delete(t);
        if (isSuccess) {
            this.delFromCache(t);
        }
        return isSuccess;
    }

    public boolean delete(long id) {
        T entity = this.get(id);
        if (entity != null) {
            return this.delete(entity);
        }
        return false;
    }

    /**
     * 将一个对象放入Cache
     *
     * @param t 向缓存保存的对象
     */
    protected void setToCache(T t) {
        IRedis msgEntityCache = this.getCacheClient();
        if (msgEntityCache != null) {
            String key = CacheUtils.genCacheKey(this.cacheKey, String.valueOf(t.getId()));
            msgEntityCache.setObject(key, t, this.cacheTime);
            String[] subKeys = this.getSubKeys(t);
            if (subKeys != null && subKeys.length > 0) {
                for (String subKey : subKeys) {
                    msgEntityCache.setObject(subKey, key, this.cacheTime);
                }
            }
        }
    }

    /**
     * 尝试从缓存中获取一个对象
     *
     * @param id 对象id
     * @return
     */
    protected T getFromCache(long id) {
        String key = CacheUtils.genCacheKey(this.cacheKey, String.valueOf(id));
        T entity = (T) this.getCacheClient().getObject(key, this.cacheTime);
        if (entity != null) {
            // TODO 以后用于统计，目前当debug
            LOGGER.debug("=== Cache bingo!!! =");
        }
        return entity;
    }

    /**
     * 尝试从缓存中获取一个对象
     *
     * @param subKey 缓存对象子key
     * @return 对象实体
     */
    protected T getFromCacheBySubKey(String subKey) {
        IRedis cacheClient = this.getCacheClient();
        Object key = cacheClient.getObject(subKey, this.cacheTime);
        if (key != null) {
            return (T) cacheClient.getObject(key.toString(), this.cacheTime);
        }
        return null;
    }

    /**
     * 尝试从缓存中删除一个对象
     *
     * @param t 对象
     */
    protected void delFromCache(T t) {
        final String key = CacheUtils.genCacheKey(this.cacheKey, String.valueOf(t.getId()));
        final String[] subKeys = this.getSubKeys(t);
        if (subKeys != null && subKeys.length > 0) {
            this.getCacheClient().pipelined(new BaseShardedJedisPipeline("BaseEntityDataService_delFromCache") {
                @Override
                public void execute() {
                    del(key);
                    for (String subKey : subKeys) {
                        del(subKey);
                    }
                }
            });
        } else {
            this.getCacheClient().del(key);
        }

    }

    protected IRedis getCacheClient() {
        return CacheUtils.getRedisCacheClient(this.cacheService, cacheServiceName);
    }

}
