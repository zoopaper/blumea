package org.stream.service.media;

import org.stream.base.service.IMybatisEntityDataService;
import org.stream.entity.MediaBean;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 22:18
 */
public interface IDataMediaService extends IMybatisEntityDataService<MediaBean> {

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

}
