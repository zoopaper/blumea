package org.stream.service.base;

import org.stream.entity.base.IMybatisEntity;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/27
 * Time: 15:59
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
