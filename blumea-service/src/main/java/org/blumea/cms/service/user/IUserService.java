package org.blumea.cms.service.user;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.UserEntity;
import org.blumea.cms.model.Pagination;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/5/25
 * Time: 14:54
 */
public interface IUserService {

    public void addUser(UserEntity userEntity) throws Exception;

    public void deleteUser(String ids);

    public void updateUser(UserEntity userEntity);

    public UserEntity getUser(long id);

    public UserEntity getUserByAccount(String account);

    /**
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public ServiceResponse<Pagination<UserEntity>> getUserWithPage(String userName, int page, int pageSize);
}
