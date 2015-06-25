package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.FunctionBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/24
 * Time: 22:15
 */
@Repository
public interface IFunctionDao extends IMybatisDao<FunctionBean> {


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
    public List<FunctionBean> getFunctionWithPage(String name, int from, int size);
}
