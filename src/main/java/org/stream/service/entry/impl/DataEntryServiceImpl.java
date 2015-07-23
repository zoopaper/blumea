package org.stream.service.entry.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stream.base.service.MybatisEntityDataService;
import org.stream.constants.cache.CacheConst;
import org.stream.dao.IEntryDao;
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
@Component
public class DataEntryServiceImpl extends MybatisEntityDataService<EntryBean> implements IDataEntryService {

    @Autowired
    private IEntryDao entryDao;

    public DataEntryServiceImpl() {
        super(CacheConst.CACHE_GROUP_ENTITY, CacheConst.CACHE_KEY_ENTRY_ENTITY_ID, CacheConst.CACHE_TIME_ENTRY_ENTITY);
    }

    @Override
    public int getEntryTotalNum(String title) {
        return entryDao.getEntryTotalNum(title);
    }

    @Override
    public List<EntryBean> getEntryWithPage(String title, int from, int size) {
        return entryDao.getEntryWithPage(title, from, size);
    }

    @Override
    protected IMybatisDao<EntryBean> getDao() {
        return entryDao;
    }

    @Override
    protected String[] getSubKeys(EntryBean entity) {
        return new String[0];
    }
}
