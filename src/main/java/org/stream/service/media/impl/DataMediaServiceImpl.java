package org.stream.service.media.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stream.base.service.MybatisEntityDataService;
import org.stream.constants.cache.CacheConst;
import org.stream.dao.IMediaDao;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.MediaBean;
import org.stream.service.media.IDataMediaService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 22:18
 */
@Component
public class DataMediaServiceImpl extends MybatisEntityDataService<MediaBean> implements IDataMediaService {


    @Autowired
    private IMediaDao mediaDao;

    public DataMediaServiceImpl() {
        super(CacheConst.CACHE_GROUP_ENTITY, CacheConst.CACHE_KEY_ROLE_ENTITY_ID, CacheConst.CACHE_TIME_MEDIA_ENTITY);
    }

    @Override
    protected IMybatisDao<MediaBean> getDao() {
        return mediaDao;
    }

    @Override
    protected String[] getSubKeys(MediaBean entity) {
        return new String[0];
    }

    @Override
    public List<MediaBean> getMediaByName(String name) {
        return mediaDao.getMediaByName(name);
    }

    @Override
    public int getMediaTotalNum(String name) {
        return mediaDao.getMediaTotalNum(name);
    }

    @Override
    public List<MediaBean> getMediaWithPage(String name, int from, int size) {
        return mediaDao.getMediaWithPage(name, from, size);
    }
}
