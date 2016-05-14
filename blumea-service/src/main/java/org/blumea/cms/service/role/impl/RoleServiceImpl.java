package org.blumea.cms.service.role.impl;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.RoleBean;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.role.IDataRoleService;
import org.blumea.cms.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/6/29
 * Time: 21:52
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IDataRoleService roleDao;

    @Override
    public void addRole(RoleBean roleBean) {
        roleDao.add(roleBean);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.delete(id);
    }

    @Override
    public void updateRole(RoleBean roleBean) {
        roleDao.update(roleBean);
    }

    @Override
    public RoleBean getRole(long id) {
        return roleDao.get(id);
    }

    @Override
    public long getRoleTotalNum(String name) {
        return roleDao.getRoleTotalNum(name);
    }

    @Override
    public ServiceResponse<Pagination<RoleBean>> getRoleWithPage(String name, int page, int size) {

        Pagination<RoleBean> roleBeanPagination = new Pagination<RoleBean>(page, size);
        int total = roleDao.getRoleTotalNum(name);
        roleBeanPagination.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<RoleBean>>(roleBeanPagination);
        }

        List<RoleBean> roleBeanList = roleDao.getRoleWithPage(name, roleBeanPagination.getFromIndex(), roleBeanPagination.getPageSize());
        if (roleBeanList == null || roleBeanList.size() == 0) {
            return ServiceResponse.genFailResponse(1);

        }
        roleBeanPagination.setItems(roleBeanList);
        return new ServiceResponse<Pagination<RoleBean>>(roleBeanPagination);
    }
}
