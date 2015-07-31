package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.sql.Timestamp;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 22:16
 */
public class FunctionBean extends IMybatisEntity {

    private long pid;

    private String name;

    private String action;

    private String param;

    private int isGroup;

    private int isDel;

    private Timestamp createTime;

    private Timestamp updateTime;

    public int getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(int isGroup) {
        this.isGroup = isGroup;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
