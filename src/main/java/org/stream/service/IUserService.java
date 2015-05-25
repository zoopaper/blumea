package org.stream.service;

import org.stream.entity.User;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 14:54
 */
public interface IUserService {

    public void addUser(User user);

    public void deleteUser(String[] ids);

    public void updateUser(User user);

    public User getUser(long id);
}
