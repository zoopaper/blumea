package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.util.Date;

/**
 * 用户
 * User: shijingui
 * Date: 2016/1/15
 */
public class UserEntity extends IMybatisEntity {

    private static final long serialVersionUID = 2157558330102156568L;

    private String account;

    private String nickName;

    private String email;

    private String password;

    private Date createTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
