package org.stream.service.user;

import org.stream.entity.UserBean;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 14:54
 */
public interface IUserService {

    public void addUser(UserBean userBean);

    public void deleteUser(String[] ids);

    public void updateUser(UserBean userBean);

    public UserBean getUser(long id);
}
