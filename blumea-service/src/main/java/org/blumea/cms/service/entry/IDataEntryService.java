package org.blumea.cms.service.entry;

import org.blumea.cms.base.service.IMybatisEntityDataService;
import org.blumea.cms.entity.EntryBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:12
 */
public interface IDataEntryService extends IMybatisEntityDataService<EntryBean> {

    /**
     * @param title
     * @return
     */
    public int getEntryTotalNum(String title, int isChannel, int subjectId);

    /**
     * @param title
     * @param from
     * @param size
     * @return
     */
    public List<EntryBean> getEntryWithPage(String title, int isChannel, int pid, int from, int size);
}
