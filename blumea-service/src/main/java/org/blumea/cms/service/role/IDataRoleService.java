package org.blumea.cms.service.role;

import org.blumea.cms.base.service.EntityDataService;
import org.blumea.cms.entity.RoleBean;

import java.util.List;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/7/2
 * Time: 8:13
 */
public interface IDataRoleService extends EntityDataService<RoleBean> {
    /**
     * @param name
     * @return
     */
    public int getRoleTotalNum(String name);


    /**
     * @param name
     * @return
     */
    public RoleBean getRoleByName(String name);


    /**
     * @param name
     * @param from
     * @param size
     * @return
     */
    public List<RoleBean> getRoleWithPage(String name, int from, int size);

}
