package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.SubjectBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:08
 */
@Repository
public interface ISubjectDao extends IMybatisDao<SubjectBean> {

    public int getSubjectTotalNum(String name);

    public List<SubjectBean> getSubjectWithPage(String name, int from, int size);

    public SubjectBean getSubjectByName(String name);

}
