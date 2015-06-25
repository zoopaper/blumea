package org.stream.service.function.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.dao.IFunctionDao;
import org.stream.entity.FunctionBean;
import org.stream.model.Pagination;
import org.stream.service.function.IFunctionService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/25
 * Time: 20:21
 */
@Service
public class FunctionServiceImpl implements IFunctionService {

    @Autowired
    private IFunctionDao functionDao;

    @Override
    public void addFunction(FunctionBean function) {
        functionDao.save(function);
    }

    @Override
    public void deleteFunction(long id) {
        FunctionBean functionBean = functionDao.get(id);
        functionDao.delete(functionBean);
    }

    @Override
    public void updateFunction(FunctionBean function) {
        functionDao.update(function);
    }

    @Override
    public FunctionBean getFunction(long id) {
        return functionDao.get(id);
    }

    @Override
    public int getFunctionTotalNum(String name) {
        return 0;
    }

    @Override
    public ServiceResponse<Pagination<FunctionBean>> getFunctionWithPage(String name, int page, int size) {

        Pagination<FunctionBean> functionPagination = new Pagination<FunctionBean>(page, size);
        int total = functionDao.getFunctionTotalNum(name);
        functionPagination.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<FunctionBean>>(functionPagination);
        }
        List<FunctionBean> functionBeanList = functionDao.getFunctionWithPage(name, functionPagination.getFromIndex(), functionPagination.getPageSize());

        if (functionBeanList == null || functionBeanList.size() == 0) {
            return ServiceResponse.genFailResponse(1);
        }

        functionPagination.setItems(functionBeanList);
        return new ServiceResponse<Pagination<FunctionBean>>(functionPagination);
    }
}
