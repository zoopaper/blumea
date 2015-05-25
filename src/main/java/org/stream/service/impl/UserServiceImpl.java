package org.stream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.dao.IUserDao;
import org.stream.entity.User;
import org.stream.service.IUserService;

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
    public void addUser(User user) {

        userDao.save(user);
    }

    @Override
    public void deleteUser(String[] ids) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUser(long id) {
        return null;
    }
}
