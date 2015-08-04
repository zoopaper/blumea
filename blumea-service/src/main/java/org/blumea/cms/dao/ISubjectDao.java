package org.blumea.cms.dao;

import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.SubjectBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:08
 */
@Repository
public interface ISubjectDao extends IMybatisDao<SubjectBean> {

    /**
     * @param name
     * @return
     */
    public int getSubjectTotalNum(String name);

    /**
     * @param name
     * @param pid
     * @return
     */
    public int getSubjectByPidTotalNum(String name, int pid);

    /**
     * @param name
     * @param from
     * @param size
     * @return
     */
    public List<SubjectBean> getSubjectWithPage(String name, int from, int size);

    /**
     * @param name
     * @return
     */
    public SubjectBean getSubjectByName(String name);


    /**
     * @param pid
     * @return
     */
    public List<SubjectBean> getSubjectByPid(int pid);

    /**
     * @param pid
     * @param name
     * @param from
     * @param size
     * @return
     */
    public List<SubjectBean> getSubjectByPidWithPage(int pid, String name, int from, int size);
}
