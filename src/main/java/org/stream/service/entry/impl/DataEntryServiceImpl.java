package org.stream.service.entry.impl;

import org.stream.base.service.MybatisEntityDataService;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.EntryBean;
import org.stream.service.entry.IDataEntryService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:16
 */
public class DataEntryServiceImpl extends MybatisEntityDataService<EntryBean> implements IDataEntryService {


    public DataEntryServiceImpl(String cacheServiceName, String cacheKey, int cacheTime) {
        super(cacheServiceName, cacheKey, cacheTime);
    }

    @Override
    public int getEntryTotalNum(String title) {
        return 0;
    }

    @Override
    public List<EntryBean> getEntryWithPage(String title, int from, int size) {
        return null;
    }

    @Override
    protected IMybatisDao<EntryBean> getDao() {
        return null;
    }

    @Override
    protected String[] getSubKeys(EntryBean entity) {
        return new String[0];
    }
}
