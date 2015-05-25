package org.stream.dao.base;

import org.stream.entity.base.IMybatisEntity;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 22:18
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
