package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.UserBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 13:56
 */
@Repository
public interface IUserDao extends IMybatisDao<UserBean> {

    /**
     * @param account
     * @return
     */
    public UserBean getUserByAccount(String account);


    /**
     * @param userName
     * @return
     */
    public int getUserTotalNum(String userName);

    /**
     * @param userName
     * @param from
     * @param size
     * @return
     */
    public List<UserBean> getUserWithPage(String userName, int from, int size);


    public boolean delteUserBatch(String ids);

}
