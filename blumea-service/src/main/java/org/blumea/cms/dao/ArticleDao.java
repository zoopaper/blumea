package org.blumea.cms.dao;

import org.blumea.cms.dao.base.BaseDao;
import org.blumea.cms.entity.ArticleEntity;
import org.blumea.cms.utils.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: shijingui
 * Date: 2016/1/16
 */
@Repository
public interface ArticleDao extends BaseDao<ArticleEntity> {

    public int getTotalNum(PageData pd);

    public List<ArticleEntity> getArticleListWithPage(PageData pd);

    /**
     * @param id
     */
    public void deleteArticleById(long id);

}
