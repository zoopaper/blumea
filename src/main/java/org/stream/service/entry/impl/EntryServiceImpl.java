package org.stream.service.entry.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.dao.IChannelDao;
import org.stream.entity.ChannelBean;
import org.stream.entity.EntryBean;
import org.stream.model.Pagination;
import org.stream.service.entry.IDataEntryService;
import org.stream.service.entry.IEntryService;

import java.util.List;

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

    @Autowired
    private IChannelDao channelDao;

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
    public ServiceResponse<Pagination<EntryBean>> getEntryWithPage(String title, int page, int pageSize) {


        Pagination<EntryBean> entryPagination = new Pagination<EntryBean>(page, pageSize);
        int total = dataEntryService.getEntryTotalNum(title);

        entryPagination.setTotal(total);
        if (total == 0) {
            return new ServiceResponse<Pagination<EntryBean>>(entryPagination);
        }
        List<EntryBean> entryBeanList = dataEntryService.getEntryWithPage(title, entryPagination.getFromIndex(), entryPagination.getPageSize());

        for (EntryBean entryBean : entryBeanList) {
            ChannelBean channelBean = channelDao.get(entryBean.getChannelId());
            if (null != channelBean) {
                entryBean.setChannelName(channelBean.getName());
            }
        }

        entryPagination.setItems(entryBeanList);
        return new ServiceResponse<Pagination<EntryBean>>(entryPagination);
    }
}
