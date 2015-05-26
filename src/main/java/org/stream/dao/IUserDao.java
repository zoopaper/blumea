package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.UserBean;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 13:56
 */
@Repository
public interface IUserDao extends IMybatisDao<UserBean> {

}
