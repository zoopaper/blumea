package org.blumea.cms.service.user.impl;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.dao.IUserDao;
import org.blumea.cms.entity.UserBean;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public void addUser(UserBean userBean) {
        userDao.save(userBean);
    }

    @Override
    public void deleteUser(String ids) {
        userDao.delteUserBatch(ids);
    }

    @Override
    public void updateUser(UserBean userBean) {

        UserBean ub = userDao.get(userBean.getId());

        {
            ub.setAccount(userBean.getAccount());
            ub.setAge(userBean.getAge());
            ub.setCity(userBean.getCity());
            ub.setEmail(userBean.getEmail());
            ub.setMobileTel(userBean.getMobileTel());
            ub.setSex(userBean.getSex());
            ub.setUpdateDate(new Date(System.currentTimeMillis()));
            ub.setUserName(userBean.getUserName());
            ub.setWork(userBean.getWork());
            ub.setWorkYear(userBean.getWorkYear());
        }

        userDao.update(ub);
    }

    @Override
    public UserBean getUser(long id) {
        return userDao.get(id);
    }

    @Override
    public UserBean getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public ServiceResponse<Pagination<UserBean>> getUserWithPage(String userName, int page, int pageSize) {

        Pagination<UserBean> userBeanPage = new Pagination<UserBean>(page, pageSize);
        int total = userDao.getUserTotalNum(userName);
        userBeanPage.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<UserBean>>(userBeanPage);
        }
        List<UserBean> userBeanList = userDao.getUserWithPage(userName, userBeanPage.getFromIndex(), userBeanPage.getPageSize());
        if (userBeanList == null || userBeanList.size() == 0) {
            return ServiceResponse.genFailResponse(1);
        }
        userBeanPage.setItems(userBeanList);
        return new ServiceResponse<Pagination<UserBean>>(userBeanPage);
    }

}
