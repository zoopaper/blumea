package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.SubjectBean;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:08
 */
@Repository
public interface ISubjectDao  extends IMybatisDao<SubjectBean> {
}
