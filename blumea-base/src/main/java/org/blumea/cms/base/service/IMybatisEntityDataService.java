package org.blumea.cms.base.service;



import org.blumea.cms.base.entity.IMybatisEntity;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * 实体类型数据服务封装接口
 * <p/>
 * 1.如果实体类型数据访问频率较高，其数据服务接口可以继承使用该接口
 * 2.封装cache ＋ db 操作
 */
public interface IMybatisEntityDataService<T extends IMybatisEntity> {

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    public T add(@Nonnull T entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    public boolean update(@Nonnull T entity);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean delete(@Nonnull long id);

    /**
     * 取得
     *
     * @param id
     * @return
     */
    public T get(@Nonnegative long id);


}
