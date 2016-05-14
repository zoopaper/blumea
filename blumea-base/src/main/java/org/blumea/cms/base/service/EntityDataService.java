package org.blumea.cms.base.service;


import org.blumea.cms.entity.base.BaseEntity;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * 实体类型数据服务封装接口
 * <p/>
 * 1.如果实体类型数据访问频率较高，其数据服务接口可以继承使用该接口
 * 2.封装cache ＋ db 操作
 */
public interface EntityDataService<T extends BaseEntity> {

    T add(@Nonnull T entity);

    boolean update(@Nonnull T entity);

    boolean delete(@Nonnull long id);

    T get(@Nonnegative long id);

}
