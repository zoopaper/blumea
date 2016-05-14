package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

import java.util.Date;

/**
 * 分类
 * User: shijingui
 * Date: 2016/1/15
 */
public class CategoryEntity extends BaseEntity {

    private static final long serialVersionUID = -7914083067154063956L;

    private String categoryName;

    private String categoryAlias;

    private long userId;

    private Date createTime;

    private short status;

    /**
     * 分类下的文章数量
     */
    private int articleNum;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
