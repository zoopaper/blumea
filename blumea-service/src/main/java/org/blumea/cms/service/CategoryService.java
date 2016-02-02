package org.blumea.cms.service;

import org.blumea.cms.dao.CategoryDao;
import org.blumea.cms.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: shijingui
 * Date: 2016/2/1
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void addCategory(CategoryEntity categoryEntity) throws Exception {
        categoryDao.save(categoryEntity);
    }

    public void updateCategory(CategoryEntity categoryEntity) throws Exception {
        categoryDao.update(categoryEntity);
    }

    public void deleteCategory(CategoryEntity categoryEntity) {
        categoryDao.delete(categoryEntity);
    }

    public CategoryEntity getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryDao.get(id);
        return categoryEntity;
    }

    public List<CategoryEntity> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
