package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

/**
 * 文章标签
 * User: shijingui
 * Date: 2016/1/16
 */
public class ArticleTagEntity extends BaseEntity {

    private static final long serialVersionUID = -573881523306846199L;

    private String tagName;

    private long articleId;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
