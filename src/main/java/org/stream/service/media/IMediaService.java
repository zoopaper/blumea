package org.stream.service.media;

import org.stream.core.model.ServiceResponse;
import org.stream.entity.MediaBean;
import org.stream.model.Pagination;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 8:44
 */
public interface IMediaService {

    /**
     * @param mediaBean
     */
    public void addMedia(MediaBean mediaBean);

    /**
     * @param id
     */
    public void deleteMedia(long id);

    /**
     * @param mediaBean
     */
    public void updateMedia(MediaBean mediaBean);

    /**
     * @param id
     * @return
     */
    public MediaBean getMedia(long id);

    /**
     * @param name
     * @return
     */
    public long getMediaTotalNum(String name);

    /**
     * @param name
     * @param page
     * @param size
     * @return
     */
    public ServiceResponse<Pagination<MediaBean>> getMediaWithPage(String name, int page, int size);
}
