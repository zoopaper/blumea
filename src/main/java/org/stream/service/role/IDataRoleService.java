package org.stream.service.role;

import org.stream.base.service.IMybatisEntityDataService;
import org.stream.entity.RoleBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 8:13
 */
public interface IDataRoleService extends IMybatisEntityDataService<RoleBean> {
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
