package org.stream.service.subject;

import org.stream.core.model.ServiceResponse;
import org.stream.entity.SubjectBean;
import org.stream.model.Pagination;

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

    public SubjectBean getSubjectByName(String name);

}
