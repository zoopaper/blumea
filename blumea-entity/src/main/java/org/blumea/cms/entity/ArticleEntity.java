package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.util.Date;

/**
 * 文章
 * User: shijingui
 * Date: 2016/1/15
 */
public class ArticleEntity extends IMybatisEntity {

    private static final long serialVersionUID = 2084106299101092317L;

    private String title;

    private String content;

    private String author;

    private Date createTime;

    private Date updateTime;

    private short status;

    private long userId;

    private long categoryId;

    private String year;

    private String month;

    private String day;

    private String summary;

    private int wordCount;

    /**
     * 文章评论数
     */
    private int commentNum;

    /**
     * 文章喜欢数量
     */
    private int favoritNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getFavoritNum() {
        return favoritNum;
    }

    public void setFavoritNum(int favoritNum) {
        this.favoritNum = favoritNum;
    }
}
