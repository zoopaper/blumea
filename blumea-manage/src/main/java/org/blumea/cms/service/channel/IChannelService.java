package org.blumea.cms.service.channel;

import org.blumea.cms.entity.ChannelBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:23
 */
public interface IChannelService {

    /**
     * @param channelBean
     */
    public void addChanel(ChannelBean channelBean);

    /**
     * @param id
     */
    public void deleteChannel(long id);

    /**
     * @param channelBean
     */
    public void updateChannel(ChannelBean channelBean);

    /**
     * @param id
     * @return
     */
    public ChannelBean getChannel(long id);

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
