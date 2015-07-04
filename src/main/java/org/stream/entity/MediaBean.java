package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

import java.sql.Timestamp;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 0:07
 */
public class MediaBean extends IMybatisEntity {

    private String name;

    private String desc;

    private String siteUrl;

    private String logoUrl;

    private int isDel;

    private Timestamp createTime;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getDesc() {
        return desc;
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
}
