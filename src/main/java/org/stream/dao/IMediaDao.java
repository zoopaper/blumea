package org.stream.dao;

import org.springframework.stereotype.Repository;
import org.stream.dao.base.IMybatisDao;
import org.stream.entity.MediaBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 23:10
 */
@Repository
public interface IMediaDao extends IMybatisDao<MediaBean> {

    public List<MediaBean> getMediaByName(String name);

    public int getMediaTotalNum(String name);


    public List<MediaBean> getMediaWithPage(String name, int from, int sizes);

}
