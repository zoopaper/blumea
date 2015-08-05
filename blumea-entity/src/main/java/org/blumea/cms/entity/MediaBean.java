package org.blumea.cms.entity;


import org.blumea.cms.entity.base.IMybatisEntity;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 0:07
 */
public class MediaBean extends IMybatisEntity {

    private String name;

    private String descs;

    private String siteUrl;

    private String logoUrl;

    private int isDel;


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


    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }


    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

}
