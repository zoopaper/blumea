package org.blumea.cms.service.user.impl;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.dao.IUserDao;
import org.blumea.cms.entity.UserEntity;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 22:23
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public void addUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public void deleteUser(String ids) {
        userDao.delteUserBatch(ids);
    }

    @Override
    public void updateUser(UserEntity userEntity) {

        UserEntity ub = userDao.get(userEntity.getId());


        userDao.update(ub);
    }

    @Override
    public UserEntity getUser(long id) {
        return userDao.get(id);
    }

    @Override
    public UserEntity getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public ServiceResponse<Pagination<UserEntity>> getUserWithPage(String userName, int page, int pageSize) {

        Pagination<UserEntity> userBeanPage = new Pagination<UserEntity>(page, pageSize);
        int total = userDao.getUserTotalNum(userName);
        userBeanPage.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<UserEntity>>(userBeanPage);
        }
        List<UserEntity> userEntityList = userDao.getUserWithPage(userName, userBeanPage.getFromIndex(), userBeanPage.getPageSize());
        if (userEntityList == null || userEntityList.size() == 0) {
            return ServiceResponse.genFailResponse(1);
        }
        userBeanPage.setItems(userEntityList);
        return new ServiceResponse<Pagination<UserEntity>>(userBeanPage);
    }

}
