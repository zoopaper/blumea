package org.blumea.cms.base.utils;


import net.common.data.redis.IRedis;
import org.blumea.cms.base.config.ServiceRedis;

/**
 * 缓存操作的相关工具类
 */
public final class CacheUtils {

    private CacheUtils() {

    }

    /**
     * 生成key
     *
     * @param key
     * @param values
     * @return
     */
    public static String genCacheKey(String key, Object... values) {
        return String.format(key, values);
    }

    /**
     * 获得指定名字的IRedis : 这里如果发现缓存服务不存在，暂时直接抛出异常，不允许访问未定义的缓存服务
     *
     * @param name
     * @return
     */
    public static IRedis getRedisCacheClient(ServiceRedis serviceRedis, String name) {
        try {
            IRedis redis = serviceRedis.getRedisNameService().get(name);
            if (redis == null) {
                throw new IllegalArgumentException(String.format("unkown cache service name like %s", name));
            }
            return redis;
        } catch (Exception e) {
            throw new RuntimeException("Cache Client get exception. name :" + name, e);
        }
    }

}
