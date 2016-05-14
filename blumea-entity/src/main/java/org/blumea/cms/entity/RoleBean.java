package org.blumea.cms.entity;


import org.blumea.cms.entity.base.BaseEntity;

import java.sql.Timestamp;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/6/24
 * Time: 0:11
 */

public class RoleBean extends BaseEntity {

    private String name;

    private String funcId;

    private String description;

    private Timestamp createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
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
}
