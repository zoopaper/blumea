package org.blumea.cms.service.entry.impl;

import org.blumea.cms.base.service.MybatisEntityDataService;
import org.blumea.cms.constants.cache.CacheConst;
import org.blumea.cms.dao.IEntryDao;
import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.EntryBean;
import org.blumea.cms.service.entry.IDataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public int getEntryTotalNum(String title, int isChannel, int subjectId) {
        return entryDao.getEntryTotalNum(title, isChannel, subjectId);
    }

    @Override
    public List<EntryBean> getEntryWithPage(String title, int isChannel, int pid, int from, int size) {
        return entryDao.getEntryWithPage(title, isChannel, pid, from, size);
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
