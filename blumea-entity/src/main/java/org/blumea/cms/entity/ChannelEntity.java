package org.blumea.cms.entity;

import org.blumea.cms.entity.base.BaseEntity;

import java.util.Date;

/**
 * 频道
 * User: shijingui
 * Date: 2016/1/15
 */
public class ChannelEntity extends BaseEntity {

    private static final long serialVersionUID = -2460538703122013153L;

    private String channelName;

    private String channelAlias;

    private String channelNamePath;

    private int pid;

    private String path;

    private Date createTime;


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelAlias() {
        return channelAlias;
    }

    public void setChannelAlias(String channelAlias) {
        this.channelAlias = channelAlias;
    }

    public String getChannelNamePath() {
        return channelNamePath;
    }

    public void setChannelNamePath(String channelNamePath) {
        this.channelNamePath = channelNamePath;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
