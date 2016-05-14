package org.blumea.cms.dao;

import org.blumea.cms.dao.base.BaseDao;
import org.blumea.cms.entity.RoleBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/6/24
 * Time: 22:22
 */
@Repository
public interface IRoleDao extends BaseDao<RoleBean> {

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
