package org.stream.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.stream.base.service.MybatisEntityDataService;
import org.stream.dao.IRoleDao;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.RoleBean;
import org.stream.service.role.IDataRoleService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 8:45
 */
public class DataRoleServiceImpl extends MybatisEntityDataService<RoleBean> implements IDataRoleService {

    @Autowired
    private IRoleDao roleDao;


    public DataRoleServiceImpl(String cacheServiceName, String cacheKey, int cacheTime) {
        super(cacheServiceName, cacheKey, cacheTime);
    }


    @Override
    public int getRoleTotalNum(String name) {
        return roleDao.getRoleTotalNum(name);
    }

    @Override
    public RoleBean getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public List<RoleBean> getRoleWithPage(String name, int from, int size) {
        return roleDao.getRoleWithPage(name, from, size);
    }

    @Override
    protected IMybatisDao<RoleBean> getDao() {
        return roleDao;
    }

    @Override
    protected String[] getSubKeys(RoleBean entity) {
        return new String[0];
    }
}
