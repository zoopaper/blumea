package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

import java.util.Date;

/**
 * 文章评论
 * User: shijingui
 * Date: 2016/1/15
 */
public class ArticleCommentEntity extends BaseEntity {

    private static final long serialVersionUID = 5573672295688453432L;

    private long userId;

    private long articleId;

    private short status;

    private String nickName;

    private String account;

    private String commentContent;

    private Date createTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}






