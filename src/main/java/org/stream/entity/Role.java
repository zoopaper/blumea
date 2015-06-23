package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 0:11
 */

public class Role extends IMybatisEntity {

    private String name;

    private String funciton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunciton() {
        return funciton;
    }

    public void setFunciton(String funciton) {
        this.funciton = funciton;
    }
}
