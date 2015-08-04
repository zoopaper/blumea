package org.blumea.cms.service.entry;

import org.blumea.cms.base.model.ServiceResponse;
import org.blumea.cms.entity.EntryBean;
import org.blumea.cms.base.model.Pagination;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:12
 */
public interface IEntryService {

    /**
     * @param entryBean
     */
    public void addEntry(EntryBean entryBean);

    /**
     * @param id
     */
    public void deleteEntry(long id);

    /**
     * @param entryBean
     */
    public void updateEntry(EntryBean entryBean);

    /**
     * @param id
     * @return
     */
    public EntryBean getEntry(long id);

    /**
     * @return
     */
    public ServiceResponse<Pagination<EntryBean>> getEntryWithPage(String title, int page, int size);


}
