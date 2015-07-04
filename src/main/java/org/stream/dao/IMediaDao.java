package org.stream.dao;

import org.stream.dao.base.IMybatisDao;
import org.stream.entity.MediaBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 23:10
 */
public interface IMediaDao extends IMybatisDao<MediaBean>{

//    /**
//     * @param mediaBean
//     */
//    public void save(MediaBean mediaBean);
//
//    /**
//     * @param mediaBean
//     */
//    public void delete(MediaBean mediaBean);
//
//    /**
//     * @param id
//     */
//    public void get(long id);
//
//    /**
//     * @param mediaBean
//     */
//    public void update(MediaBean mediaBean);

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

}
