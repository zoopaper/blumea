package org.blumea.cms.service;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.dao.ArticleDao;
import org.blumea.cms.entity.ArticleEntity;
import org.blumea.cms.model.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public ServiceResponse<Pagination<ArticleEntity>> getArticleListWithPage(String title, int categoryId, int page, int pageSize) throws Exception {
        Pagination<ArticleEntity> articlePagination = new Pagination<ArticleEntity>(page, pageSize);
        int total = articleDao.getTotalNum(title, categoryId);
        articlePagination.setTotal(total);
        if (total == 0) {
            return new ServiceResponse<Pagination<ArticleEntity>>(articlePagination);
        }
        List<ArticleEntity> articleList = articleDao.getArticleListWithPage(title, categoryId, articlePagination.getFromIndex(), articlePagination.getPageSize());

        articlePagination.setItems(articleList);
        return new ServiceResponse<Pagination<ArticleEntity>>(articlePagination);
    }

}
