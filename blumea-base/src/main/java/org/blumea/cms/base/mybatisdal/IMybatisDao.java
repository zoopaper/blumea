package org.blumea.cms.base.mybatisdal;

import org.blumea.cms.base.entity.IMybatisEntity;

/**
 * Dao的基础接口
 * User: dongyong.wang@ran-inc.com
 * Date: 11-10-13
 * Time: 下午2:24
 */
public interface IMybatisDao<T extends IMybatisEntity> {
    /**
     * 保存一个实体对象
     *
     * @param entity
     * @return
     */
    public long save(T entity);

    /**
     * 保存一个实体
     *
     * @param entity
     * @return
     */
    public boolean update(T entity);

    /**
     * 删除一个实体
     *
     * @param entity
     * @return
     */
    public boolean delete(T entity);

    /**
     * 取得一个实体
     *
     * @param id
     * @return
     */
    public T get(long id);
}
