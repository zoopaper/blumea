package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

import java.util.Date;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/5/25
 * Time: 21:51
 */
public class UserEntity extends BaseEntity {

    private String username;

    private String account;

    private String password;

    private String email;

    private short status;

    private Date createTime;

    private short activation;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public short getActivation() {
        return activation;
    }

    public void setActivation(short activation) {
        this.activation = activation;
    }
}
