package org.blumea.cms.web.controller;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.MediaBean;
import org.blumea.cms.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.media.IMediaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/2
 * Time: 22:17
 */
@Controller
@RequestMapping("/adm/media")
public class MediaController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(MediaController.class);

    @Autowired
    private IMediaService mediaService;

    @RequestMapping(value = "/addMedia", method = RequestMethod.GET)
    public ModelAndView addMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/media/addMedia");
        return modelAndView;
    }


    @RequestMapping(value = "/doAddMedia", method = RequestMethod.POST)
    public ModelAndView doAddMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String siteUrl = ServletRequestUtils.getStringParameter(request, "siteUrl", "");
            String logoUrl = ServletRequestUtils.getStringParameter(request, "logoUrl", "");
            String desc = ServletRequestUtils.getStringParameter(request, "desc", "");


            MediaBean media = new MediaBean();
            {
                media.setName(name);
                media.setSiteUrl(siteUrl);
                media.setLogoUrl(logoUrl);
                media.setDescs(desc);
            }
            mediaService.addMedia(media);
        } catch (Exception e) {
            log.info("Controller doAddMedia exception", e);
        }
        modelAndView.setViewName("redirect:/adm/media/mediaList");
        return modelAndView;
    }


    @RequestMapping(value = "/toModifyMedia", method = RequestMethod.GET)
    public ModelAndView toModifyMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("/media/modifyMedia");
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            MediaBean media = mediaService.getMedia(id);
            if (media != null) {
                modelAndView.addObject("media", media);
            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifyMedia exception", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/doModifyMedia", method = RequestMethod.POST)
    public ModelAndView doModifyMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/media/mediaList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String logoUrl = ServletRequestUtils.getStringParameter(request, "logoUrl", "");
            String siteUrl = ServletRequestUtils.getStringParameter(request, "siteUrl", "");
            String desc = ServletRequestUtils.getStringParameter(request, "desc", "");

            MediaBean media = new MediaBean();
            {
                media.setId(id);
                media.setName(name);
                media.setLogoUrl(logoUrl);
                media.setSiteUrl(siteUrl);
                media.setDescs(desc);
            }
            mediaService.updateMedia(media);
        } catch (Exception e) {
            log.info("Controller doModifyMedia exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/mediaList", method = RequestMethod.GET)
    public ModelAndView subjectList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/media/mediaList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");

            ServiceResponse<Pagination<MediaBean>> serviceResponse = mediaService.getMediaWithPage(name, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("page", serviceResponse.getResponseData());
            modelAndView.addObject("name", name);
        } catch (Exception e) {
            log.info("Controller mediaList exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delMedia", method = RequestMethod.GET)
    public ModelAndView deleteMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/media/mediaList");

            String idArr = ServletRequestUtils.getStringParameter(request, "id");
            String[] ids = idArr.split(",");
            for (String id : ids) {
                mediaService.deleteMedia(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller delMedia exception", e);
        }
        return modelAndView;
    }

}
