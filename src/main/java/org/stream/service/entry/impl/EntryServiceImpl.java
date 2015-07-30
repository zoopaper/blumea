package org.stream.service.entry.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.EntryBean;
import org.stream.model.Pagination;
import org.stream.service.entry.IDataEntryService;
import org.stream.service.entry.IEntryService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:16
 */
@Service
public class EntryServiceImpl implements IEntryService {

    @Autowired
    private IDataEntryService dataEntryService;

    @Override
    public void addEntry(EntryBean entryBean) {
        dataEntryService.add(entryBean);
    }

    @Override
    public void deleteEntry(long id) {
        dataEntryService.delete(id);
    }

    @Override
    public void updateEntry(EntryBean entryBean) {
        dataEntryService.update(entryBean);
    }

    @Override
    public EntryBean getEntry(long id) {
        return dataEntryService.get(id);
    }

    @Override
    public ServiceResponse<Pagination<EntryBean>> getEntryWithPage(String title, int page, int size) {

        int total = dataEntryService.getEntryTotalNum(title);

        dataEntryService.getEntryWithPage(title, page, size);
        return null;
    }
}
