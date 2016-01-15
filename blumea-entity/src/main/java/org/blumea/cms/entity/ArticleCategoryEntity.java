package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.util.Date;

/**
 * 分类
 * User: shijingui
 * Date: 2016/1/15
 */
public class ArticleCategoryEntity extends IMybatisEntity {

    private static final long serialVersionUID = -7914083067154063956L;

    private String categoryName;

    private String categoryAlias;

    private long userId;

    private Date createTime;

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
}
