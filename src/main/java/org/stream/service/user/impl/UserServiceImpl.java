package org.stream.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.dao.IUserDao;
import org.stream.entity.UserBean;
import org.stream.service.user.IUserService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 22:23
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;

    @Override
    public void addUser(UserBean userBean) {

        userDao.save(userBean);
    }

    @Override
    public void deleteUser(String[] ids) {

    }

    @Override
    public void updateUser(UserBean userBean) {
        userDao.update(userBean);
    }

    @Override
    public UserBean getUser(long id) {
        return userDao.get(id);
    }

    @Override
    public UserBean getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }
}
