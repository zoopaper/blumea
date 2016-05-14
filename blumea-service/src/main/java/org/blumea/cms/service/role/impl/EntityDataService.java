package org.blumea.cms.service.role.impl;

import org.blumea.cms.constants.cache.CacheConst;
import org.blumea.cms.dao.IRoleDao;
import org.blumea.cms.dao.base.BaseDao;
import org.blumea.cms.entity.RoleBean;
import org.blumea.cms.service.role.IDataRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/7/2
 * Time: 8:45
 */
@Component
public class EntityDataService extends org.blumea.cms.base.service.BaseEntityDataService<RoleBean> implements IDataRoleService {

    @Autowired
    private IRoleDao roleDao;


    public EntityDataService() {
        super(CacheConst.CACHE_GROUP_ENTITY, CacheConst.CACHE_KEY_ROLE_ENTITY_ID, CacheConst.CACHE_TIME_ROLE_ENTITY);
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
    protected BaseDao<RoleBean> getDao() {
        return roleDao;
    }

    @Override
    protected String[] getSubKeys(RoleBean entity) {
        return new String[0];
    }
}
