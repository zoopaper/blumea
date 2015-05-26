package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

import java.util.Date;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 21:51
 */
public class UserBean extends IMybatisEntity {

    private String userName;

    private String account;

    private String password;

    private int isDel;

    private Date createDate;

    private Date updateDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
