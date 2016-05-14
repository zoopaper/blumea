package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

import java.util.Date;

/**
 * 收藏的文章
 * User: shijingui
 * Date: 2016/1/15
 */
public class ArticleCollectEntity extends BaseEntity {

    private static final long serialVersionUID = -6720987174165350430L;

    private long userId;

    private String articleTitle;

    /**
     * 文章所属用户
     */
    private String account;

    /**
     * 文章发布时间
     */
    private Date articleCreateTime;

    /**
     * 收藏时间
     */
    private Date collectTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
