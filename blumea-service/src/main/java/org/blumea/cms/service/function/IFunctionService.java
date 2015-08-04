package org.blumea.cms.service.function;

import org.blumea.cms.base.model.ServiceResponse;
import org.blumea.cms.entity.FunctionBean;
import org.blumea.cms.base.model.Pagination;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/25
 * Time: 18:09
 */
public interface IFunctionService {

    /**
     * @param function
     */
    public void addFunction(FunctionBean function);

    /**
     * @param id
     */
    public void deleteFunction(long id);

    /**
     * @param function
     */
    public void updateFunction(FunctionBean function);

    /**
     * @param id
     * @return
     */
    public FunctionBean getFunction(long id);

    /**
     * @param name
     * @return
     */
    public int getFunctionTotalNum(String name);

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
    public ServiceResponse<Pagination<FunctionBean>> getFunctionWithPage(String name, int page, int size);

}
