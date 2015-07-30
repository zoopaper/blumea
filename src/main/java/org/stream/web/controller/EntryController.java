package org.stream.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.stream.auth.Principal;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.ChannelBean;
import org.stream.entity.EntryBean;
import org.stream.entity.MediaBean;
import org.stream.model.Pagination;
import org.stream.service.channel.IChannelService;
import org.stream.service.entry.IEntryService;
import org.stream.service.media.IDataMediaService;
import org.stream.service.subject.ISubjectService;
import org.stream.web.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/14
 * Time: 22:07
 */
@Controller
@RequestMapping("/adm/entry")
public class EntryController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(EntryController.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private IDataMediaService dataMediaService;

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private IEntryService entryService;

    @RequestMapping(value = "/addEntry", method = RequestMethod.GET)
    public ModelAndView addEntry(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/entry/addEntry");

        List<ChannelBean> channelBeanList = channelService.getAllChannel();
        List<MediaBean> mediaBeans = dataMediaService.getAllMedia();

        modelAndView.addObject("channelList", channelBeanList);

        modelAndView.addObject("mediaList", mediaBeans);

        subjectService.getSubjectByPid(1);
        return modelAndView;
    }


    @RequestMapping(value = "/doAddEntry", method = RequestMethod.POST)
    public ModelAndView doAddMedia(@RequestParam(value = "content") String content, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            String title = ServletRequestUtils.getStringParameter(request, "title", "");
            String subhead = ServletRequestUtils.getStringParameter(request, "subhead", "");
            String author = ServletRequestUtils.getStringParameter(request, "author", "");
            String dutyEditor = ServletRequestUtils.getStringParameter(request, "dutyEditor", "");
            String media = ServletRequestUtils.getStringParameter(request, "media", "");
            String url = ServletRequestUtils.getStringParameter(request, "url", "");
            String keyword = ServletRequestUtils.getStringParameter(request, "keyword", "");
            String tag = ServletRequestUtils.getStringParameter(request, "tag", "");
            String summary = ServletRequestUtils.getStringParameter(request, "summary", "");
            int channelId = ServletRequestUtils.getIntParameter(request, "channelId", 0);


            EntryBean entryBean = new EntryBean();
            {
                entryBean.setTitle(title);
                entryBean.setSubhead(subhead);
                entryBean.setAuthor(author);
                entryBean.setContent(content);
                entryBean.setKeyword(keyword);
                entryBean.setDutyEditor(dutyEditor);
                entryBean.setMediaId(Integer.valueOf(media));
                entryBean.setUrl(url);
                entryBean.setTag(tag);
                entryBean.setSummary(summary);
                entryBean.setChannelId(channelId);
                entryBean.setCtime(new Timestamp(System.currentTimeMillis()));
            }

            entryService.addEntry(entryBean);
        } catch (Exception e) {
            log.info("Controller doAddEntry exception", e);
        }
        modelAndView.setViewName("redirect:/adm/entry/addEntry");
        return modelAndView;
    }


    @RequestMapping(value = "/toModifyEntry", method = RequestMethod.GET)
    public ModelAndView toModifyEntry(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/entry/modifyEntry");
        List<ChannelBean> channelBeanList = channelService.getAllChannel();
        List<MediaBean> mediaBeans = dataMediaService.getAllMedia();

        modelAndView.addObject("channelList", channelBeanList);

        modelAndView.addObject("mediaList", mediaBeans);
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            int id = ServletRequestUtils.getIntParameter(request, "id", 0);
            EntryBean entryBean = entryService.getEntry(id);
            modelAndView.addObject("entry", entryBean);
        } catch (Exception e) {
            log.info("Controller toModifyEntry exception", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/doModifyEntry", method = RequestMethod.POST)
    public ModelAndView doModifyMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/entry/entryList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String title = ServletRequestUtils.getStringParameter(request, "title", "");
            String subhead = ServletRequestUtils.getStringParameter(request, "subhead", "");
            String author = ServletRequestUtils.getStringParameter(request, "author", "");
            String dutyEditor = ServletRequestUtils.getStringParameter(request, "dutyEditor", "");
            String media = ServletRequestUtils.getStringParameter(request, "media", "");
            String url = ServletRequestUtils.getStringParameter(request, "url", "");
            String keyword = ServletRequestUtils.getStringParameter(request, "keyword", "");
            String tag = ServletRequestUtils.getStringParameter(request, "tag", "");
            String summary = ServletRequestUtils.getStringParameter(request, "summary", "");
            String content = ServletRequestUtils.getStringParameter(request, "content", "");

            int channelId = ServletRequestUtils.getIntParameter(request, "channelId", 0);

            EntryBean entryBean = new EntryBean();
            {
                entryBean.setId(id);
                entryBean.setTitle(title);
                entryBean.setSubhead(subhead);
                entryBean.setAuthor(author);
                entryBean.setContent(content);
                entryBean.setKeyword(keyword);
                entryBean.setDutyEditor(dutyEditor);
                entryBean.setMediaId(Integer.valueOf(media));
                entryBean.setUrl(url);
                entryBean.setTag(tag);
                entryBean.setSummary(summary);
                entryBean.setChannelId(channelId);
                entryBean.setUptime(new Timestamp(System.currentTimeMillis()));
            }
            entryService.updateEntry(entryBean);
        } catch (Exception e) {
            log.info("Controller doModifyEntry exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/entryList", method = RequestMethod.GET)
    public ModelAndView subjectList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/entry/entryList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String title = ServletRequestUtils.getStringParameter(request, "title", "");

            ServiceResponse<Pagination<EntryBean>> serviceResponse = entryService.getEntryWithPage(title, page, 15);
            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("page", serviceResponse.getResponseData());
            modelAndView.addObject("title", title);
        } catch (Exception e) {
            log.info("Controller entryList exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delEntry", method = RequestMethod.GET)
    public ModelAndView deleteMedia(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/entry/entryList");

            String idArr = ServletRequestUtils.getStringParameter(request, "id");
            String[] ids = idArr.split(",");
            for (String id : ids) {
            }
        } catch (Exception e) {
            log.info("Controller delEntry exception", e);
        }
        return modelAndView;
    }
}
