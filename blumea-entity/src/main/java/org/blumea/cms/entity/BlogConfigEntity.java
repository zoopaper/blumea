package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

/**
 * 用户博客设置
 * User: shijingui
 * Date: 2016/1/15
 */
public class BlogConfigEntity extends IMybatisEntity {

    private static final long serialVersionUID = -8291231251985984165L;

    private String blogTitle;

    private String blogSubTitle;

    private long userId;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSubTitle() {
        return blogSubTitle;
    }

    public void setBlogSubTitle(String blogSubTitle) {
        this.blogSubTitle = blogSubTitle;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
