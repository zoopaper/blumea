package org.stream.service.media.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.MediaBean;
import org.stream.model.Pagination;
import org.stream.service.media.IDataMediaService;
import org.stream.service.media.IMediaService;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 8:49
 */
@Service
public class MediaServiceImpl implements IMediaService {

    @Autowired
    private IDataMediaService dataMediaService;

    @Override
    public void addMedia(MediaBean mediaBean) {
        dataMediaService.add(mediaBean);
    }

    @Override
    public void deleteMedia(long id) {
        dataMediaService.delete(id);
    }

    @Override
    public void updateMedia(MediaBean mediaBean) {
        dataMediaService.update(mediaBean);
    }

    @Override
    public MediaBean getMedia(long id) {
        return dataMediaService.get(id);
    }

    @Override
    public long getMediaTotalNum(String name) {
        return dataMediaService.getMediaTotalNum(name);
    }

    @Override
    public ServiceResponse<Pagination<MediaBean>> getMediaWithPage(String name, int page, int size) {
        Pagination<MediaBean> mediaBeanPagination = new Pagination<MediaBean>(page, size);
        int total = dataMediaService.getMediaTotalNum(name);
        mediaBeanPagination.setTotal(total);

        if (total == 0) {
            return new ServiceResponse<Pagination<MediaBean>>(mediaBeanPagination);
        }

        List<MediaBean> roleBeanList = dataMediaService.getMediaWithPage(name, mediaBeanPagination.getFromIndex(), mediaBeanPagination.getPageSize());
        if (roleBeanList == null || roleBeanList.size() == 0) {
            return ServiceResponse.genFailResponse(1);

        }
        mediaBeanPagination.setItems(roleBeanList);
        return new ServiceResponse<Pagination<MediaBean>>(mediaBeanPagination);
    }
}
