package org.blumea.cms.service.role;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.RoleBean;
import org.blumea.cms.model.Pagination;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/29
 * Time: 21:50
 */
public interface IRoleService {

    /**
     * @param roleBean
     */
    public void addRole(RoleBean roleBean);

    /**
     * @param id
     */
    public void deleteRole(long id);

    /**
     * @param roleBean
     */
    public void updateRole(RoleBean roleBean);

    /**
     * @param id
     * @return
     */
    public RoleBean getRole(long id);

    /**
     * @param name
     * @return
     */
    public long getRoleTotalNum(String name);

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
    public ServiceResponse<Pagination<RoleBean>> getRoleWithPage(String name, int page, int size);
}
