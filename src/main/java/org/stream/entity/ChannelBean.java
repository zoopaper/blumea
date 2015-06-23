package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

import java.sql.Timestamp;

/**
 * 频道
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 20:43
 */
public class ChannelBean extends IMybatisEntity {

    private String name;

    /**
     * 频道目录
     */
    private String dir;

    private int isDel;

    private Timestamp createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
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
