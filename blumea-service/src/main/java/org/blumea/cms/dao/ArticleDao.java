package org.blumea.cms.dao;

import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.ArticleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: shijingui
 * Date: 2016/1/16
 */
@Repository
public interface ArticleDao extends IMybatisDao<ArticleEntity> {

    /**
     * @param title
     * @return
     */
    public int getTotalNum(String title, int categoryId);

    /**
     * @param title
     * @param from
     * @param size
     * @return
     */
    public List<ArticleEntity> getArticleListWithPage(String title, int from, int size, int category_id);

    /**
     * @param id
     */
    public void deleteArticleById(long id);

}
