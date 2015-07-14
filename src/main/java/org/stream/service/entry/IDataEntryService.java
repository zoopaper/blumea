package org.stream.service.entry;

import org.stream.base.service.IMybatisEntityDataService;
import org.stream.entity.EntryBean;

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
    public int getEntryTotalNum(String title);

    /**
     * @param title
     * @param from
     * @param size
     * @return
     */
    public List<EntryBean> getEntryWithPage(String title, int from, int size);
}
