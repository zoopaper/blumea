package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

/**
 * 频道
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 20:43
 */
public class Channel extends IMybatisEntity {

    private String name;

    /**
     *频道目录
     */
    private String dir;

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
}
