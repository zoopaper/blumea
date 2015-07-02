package org.stream.service.media.impl;

import org.stream.base.service.MybatisEntityDataService;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.MediaBean;
import org.stream.service.media.IDataMediaService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 22:18
 */
public class DateMediaServiceImpl extends MybatisEntityDataService<MediaBean> implements IDataMediaService {


    public DateMediaServiceImpl(String cacheServiceName, String cacheKey, int cacheTime) {
        super(cacheServiceName, cacheKey, cacheTime);
    }

    @Override
    protected IMybatisDao<MediaBean> getDao() {
        return null;
    }

    @Override
    protected String[] getSubKeys(MediaBean entity) {
        return new String[0];
    }
}
