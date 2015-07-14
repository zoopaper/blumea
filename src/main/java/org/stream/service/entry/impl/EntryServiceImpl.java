package org.stream.service.entry.impl;

import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.EntryBean;
import org.stream.model.Pagination;
import org.stream.service.entry.IEntryService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:16
 */
@Service
public class EntryServiceImpl implements IEntryService {



    @Override
    public void addEntry(EntryBean entryBean) {

    }

    @Override
    public void deleteEntry(long id) {

    }

    @Override
    public void updateEntry(EntryBean entryBean) {

    }

    @Override
    public EntryBean getEntry(long id) {
        return null;
    }

    @Override
    public ServiceResponse<Pagination<EntryBean>> getEntryWithPage(String title, int page, int size) {
        return null;
    }
}
