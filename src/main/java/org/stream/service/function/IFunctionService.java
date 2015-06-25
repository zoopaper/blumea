package org.stream.service.function;

import org.stream.core.model.ServiceResponse;
import org.stream.entity.Function;
import org.stream.entity.FunctionBean;
import org.stream.model.Pagination;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/25
 * Time: 18:09
 */
public interface IFunctionService {


    public void addFunction(FunctionBean function);

    public void deleteFunction(long id);

    public void updateFunction(Function function);

    public FunctionBean getFunction(long id);

    /**
     * @param name
     * @return
     */
    public int getFunctionTotalNum(String name);

    /**
     * @param name
     * @param from
     * @param size
     * @return
     */
    public ServiceResponse<Pagination<List<FunctionBean>>> getFunctionWithPage(String name, int from, int size);

}
