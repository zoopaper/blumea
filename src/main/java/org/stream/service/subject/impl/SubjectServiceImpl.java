package org.stream.service.subject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.dao.ISubjectDao;
import org.stream.entity.SubjectBean;
import org.stream.model.Pagination;
import org.stream.service.subject.ISubjectService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 22:19
 */
@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private ISubjectDao subjectDao;

    @Override
    public void addSubject(SubjectBean subjectBean) {
        subjectDao.save(subjectBean);
    }

    @Override
    public void deleteSubject(long id) {
        SubjectBean subjectBean = subjectDao.get(id);
        subjectDao.delete(subjectBean);
    }

    @Override
    public void updateSubject(SubjectBean subjectBean) {
        subjectDao.update(subjectBean);
    }

    @Override
    public SubjectBean getSubject(long id) {
        return subjectDao.get(id);
    }


    public ServiceResponse<Pagination<SubjectBean>> getSubjectWithPage(String name, int page, int pageSize) {
        Pagination<SubjectBean> subjectPage = new Pagination<SubjectBean>(page, pageSize);
        int total = subjectDao.getSubjectTotalNum(name);
        subjectPage.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<SubjectBean>>(subjectPage);
        }

        List<SubjectBean> userBeanList = subjectDao.getSubjectWithPage(name, subjectPage.getFromIndex(), subjectPage.getPageSize());

        if (userBeanList == null || userBeanList.size() == 0) {
            return ServiceResponse.genFailResponse(1);
        }
        subjectPage.setItems(userBeanList);
        return new ServiceResponse<Pagination<SubjectBean>>(subjectPage);

    }
}
