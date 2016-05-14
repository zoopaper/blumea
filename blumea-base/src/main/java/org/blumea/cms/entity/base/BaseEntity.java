package org.blumea.cms.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * User : shijingui
 * Date: 2015/5/25
 * Time: 22:13
 */
public class BaseEntity implements Serializable {

    private Long id;
    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
