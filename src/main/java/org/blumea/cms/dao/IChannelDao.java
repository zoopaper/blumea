package org.blumea.cms.dao;

import org.blumea.cms.dao.base.IMybatisDao;
import org.springframework.stereotype.Repository;
import org.blumea.cms.entity.ChannelBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:08
 */
@Repository
public interface IChannelDao extends IMybatisDao<ChannelBean> {


    /**
     * @return
     */
    public List<ChannelBean> getAllChannel();

    /**
     * @param name
     * @return
     */
    public ChannelBean getChannelByName(String name);


}
