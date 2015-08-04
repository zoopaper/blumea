package org.blumea.cms.dao;

import org.blumea.cms.dao.base.IMybatisDao;
import org.blumea.cms.entity.MediaBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 23:10
 */
@Repository
public interface IMediaDao extends IMybatisDao<MediaBean> {

    /**
     * @param name
     * @return
     */
    public List<MediaBean> getMediaByName(String name);

    /**
     * @param name
     * @return
     */
    public int getMediaTotalNum(String name);

    /**
     * @param name
     * @param from
     * @param size
     * @return
     */
    public List<MediaBean> getMediaWithPage(String name, int from, int size);


    public List<MediaBean> getAllMedia();


}
