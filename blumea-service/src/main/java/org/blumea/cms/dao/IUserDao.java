package org.blumea.cms.dao;

import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 13:56
 */
@Repository
public interface IUserDao extends IMybatisDao<UserEntity> {

    /**
     * @param account
     * @return
     */
    public UserEntity getUserByAccount(String account);


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
    public List<UserEntity> getUserWithPage(String userName, int from, int size);


    public boolean delteUserBatch(String ids);

}
