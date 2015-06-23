package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 0:15
 */
public class Function extends IMybatisEntity {

    private String name;

    private String actoin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActoin() {
        return actoin;
    }

    public void setActoin(String actoin) {
        this.actoin = actoin;
    }
}
