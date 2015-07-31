package org.blumea.cms.dao;

import org.springframework.stereotype.Repository;
import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.EntryBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 23:10
 */
@Repository
public interface IEntryDao extends IMybatisDao<EntryBean> {

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
