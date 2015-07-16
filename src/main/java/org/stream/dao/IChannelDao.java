package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.ChannelBean;

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
