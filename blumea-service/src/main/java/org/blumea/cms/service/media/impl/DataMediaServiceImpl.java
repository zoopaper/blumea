package org.blumea.cms.service.media.impl;

import org.blumea.cms.base.service.MybatisEntityDataService;
import org.blumea.cms.constants.cache.CacheConst;
import org.blumea.cms.dao.IMediaDao;
import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.MediaBean;
import org.blumea.cms.service.media.IDataMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        super(CacheConst.CACHE_GROUP_ENTITY, CacheConst.CACHE_KEY_MEDIA_ENTITY_ID, CacheConst.CACHE_TIME_MEDIA_ENTITY);
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

    @Override
    public List<MediaBean> getAllMedia() {
        return mediaDao.getAllMedia();
    }
}
