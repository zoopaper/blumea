package org.blumea.cms.dao.base;

import org.blumea.cms.entity.base.BaseEntity;

/**
 * User : shijingui
 * Date: 2015/5/25
 * Time: 22:18
 */
public interface BaseDao<T extends BaseEntity> {

    long save(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    T get(long id);

}
