package org.blumea.cms.service.user;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.UserBean;
import org.blumea.cms.model.Pagination;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 14:54
 */
public interface IUserService {

    public void addUser(UserBean userBean);

    public void deleteUser(String ids);

    public void updateUser(UserBean userBean);

    public UserBean getUser(long id);

    public UserBean getUserByAccount(String account);

    /**
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public ServiceResponse<Pagination<UserBean>> getUserWithPage(String userName, int page, int pageSize);
}
