package org.stream.service.channel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.dao.IChannelDao;
import org.stream.entity.ChannelBean;
import org.stream.service.channel.IChannelService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:26
 */
@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private IChannelDao channelDao;

    @Override
    public void addChanel(ChannelBean channelBean) {
        channelDao.save(channelBean);
    }

    @Override
    public void deleteChannel(long id) {
        ChannelBean channelBean = channelDao.get(id);
        channelDao.delete(channelBean);
    }

    @Override
    public void updateChannel(ChannelBean channelBean) {
        channelDao.update(channelBean);
    }

    @Override
    public ChannelBean getChannel(long id) {
        return channelDao.get(id);
    }

    @Override
    public List<ChannelBean> getAllChannel() {
        return channelDao.getAllChannel();
    }

    /**
     * @param name
     * @return
     */
    @Override
    public ChannelBean getChannelByName(String name) {
        return channelDao.getChannelByName(name);
    }
}
