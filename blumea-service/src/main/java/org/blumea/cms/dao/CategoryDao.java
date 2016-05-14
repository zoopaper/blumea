package org.blumea.cms.dao;

import org.blumea.cms.dao.base.BaseDao;
import org.blumea.cms.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: shijingui
 * Date: 2016/2/1
 */
@Repository
public interface CategoryDao extends BaseDao<CategoryEntity> {

    public List<CategoryEntity> getAllCategory();
}
