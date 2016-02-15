package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.util.Date;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 21:51
 */
public class UserEntity extends IMybatisEntity {

    private String username;

    private String account;

    private String password;

    private String email;

    private int isDel;

    private Date createDate;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
