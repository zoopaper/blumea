package org.blumea.cms.entity;

import org.blumea.cms.entity.base.IMybatisEntity;

import java.sql.Timestamp;

/**
 * 栏目
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 21:11
 */
public class SubjectBean extends IMybatisEntity {

    private long pid;

    private String parentPath;

    private String category;//父对象的全路径，以";"分割

    private String shortName;//发布英文名称

    private String name;    //栏目名字

    private long channelId;

    private String channelName;

    private long templateId;

    private int status;

    private String statusStr;

    private int priority;

    private int type;

    private String tags;    //关键词

    private String description;    //描述

    private Timestamp createTime;

    private Timestamp updateTime;


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }


    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getStatusStr() {
        String ret;
        if (status == 1) {
            ret = "有效";
        } else {
            ret = "无效";
        }
        return ret;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
