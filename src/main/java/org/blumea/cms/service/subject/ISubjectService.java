package org.blumea.cms.service.subject;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.SubjectBean;
import org.blumea.cms.model.Pagination;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 22:17
 */
public interface ISubjectService {

    /**
     * @param subjectBean
     */
    public void addSubject(SubjectBean subjectBean);

    /**
     * @param id
     */
    public void deleteSubject(long id);

    /**
     * @param subjectBean
     */
    public void updateSubject(SubjectBean subjectBean);

    /**
     * @param id
     */
    public SubjectBean getSubject(long id);


    /**
     * @param name
     * @param from
     * @param size
     * @return
     */
    public ServiceResponse<Pagination<SubjectBean>> getSubjectWithPage(String name, int from, int size);

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
    public ServiceResponse<Pagination<SubjectBean>> getSubjectByPidWithPage(int pid, String name, int from, int size);


}
