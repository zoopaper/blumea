package org.blumea.cms.service;

import org.blumea.cms.dao.ArticleDao;
import org.blumea.cms.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: shijingui
 * Date: 2016/1/16
 */
@Service
public class ArticleService {


    @Autowired
    private ArticleDao articleDao;

    public void addArticle(ArticleEntity article) throws Exception {
        articleDao.save(article);
    }

    public ArticleEntity getArticleById(long id) throws Exception {
        return articleDao.get(id);
    }

    public void updateArticle(ArticleEntity article) throws Exception {
        articleDao.update(article);
    }

    public void deleteArticle(long id) throws Exception {
        articleDao.deleteArticleById(id);
    }

}
