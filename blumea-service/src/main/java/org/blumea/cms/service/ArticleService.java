package org.blumea.cms.service;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.dao.ArticleDao;
import org.blumea.cms.entity.ArticleEntity;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: shijingui
 * Date: 2016/1/16
 */
@Service
public class ArticleService {


    @Resource
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


    public ServiceResponse<Pagination<ArticleEntity>> getArticleListWithPage(PageData pd) throws Exception {
        Pagination<ArticleEntity> articlePagination = new Pagination<ArticleEntity>(pd.getInt("page"), pd.getInt("pageSize"));
        int total = articleDao.getTotalNum(pd);
        articlePagination.setTotal(total);
        if (total == 0) {
            return new ServiceResponse<Pagination<ArticleEntity>>(articlePagination);
        }
        pd.put("from", articlePagination.getFromIndex());
        pd.put("size", articlePagination.getPageSize());
        List<ArticleEntity> articleList = articleDao.getArticleListWithPage(pd);

        articlePagination.setItems(articleList);
        return new ServiceResponse<Pagination<ArticleEntity>>(articlePagination);
    }

}
