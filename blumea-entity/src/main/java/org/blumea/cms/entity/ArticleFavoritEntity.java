package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

/**
 * 文章喜欢属性对象
 * User: shijingui
 * Date: 2016/1/16
 */
public class ArticleFavoritEntity extends IMybatisEntity {

    private static final long serialVersionUID = -4544665159080852749L;

    private long articleId;

    private String articleTitle;

    private int countNum;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }
}
