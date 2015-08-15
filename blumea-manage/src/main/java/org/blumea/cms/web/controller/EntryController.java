package org.blumea.cms.web.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.ChannelBean;
import org.blumea.cms.entity.EntryBean;
import org.blumea.cms.entity.MediaBean;
import org.blumea.cms.entity.SubjectBean;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.channel.IChannelService;
import org.blumea.cms.service.entry.IEntryService;
import org.blumea.cms.service.media.IDataMediaService;
import org.blumea.cms.service.subject.ISubjectService;
import org.blumea.cms.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        modelAndView.setViewName("/entry/docTree");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String title = ServletRequestUtils.getStringParameter(request, "title", "");
            int pid = ServletRequestUtils.getIntParameter(request, "pid", -1);
            int isChannel = ServletRequestUtils.getIntParameter(request, "isChannel", -1);


            ServiceResponse<Pagination<EntryBean>> serviceResponse = entryService.getEntryWithPage(title, isChannel, pid, page, 15);
            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("pid", pid);
            modelAndView.addObject("isChannel", isChannel);
            modelAndView.addObject("page", serviceResponse.getResponseData());
            modelAndView.addObject("title", title);
        } catch (Exception e) {
            log.info("Controller entryList exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delEntry", method = RequestMethod.GET)
    public ModelAndView delEntry(HttpServletRequest request, HttpServletResponse response) {
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
                entryService.deleteEntry(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller delEntry exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/toDoc", method = RequestMethod.GET)
    public ModelAndView toChannelTree(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/entry/docTree");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
        } catch (Exception e) {
            log.info("Controller toDoc exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/docTree", method = RequestMethod.POST)
    public ModelAndView channelTree(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/resultdata");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            int id = ServletRequestUtils.getIntParameter(request, "id", 0);

            JsonArray jsonArray;
            if (id == 0) {
                List<ChannelBean> channelList = channelService.getAllChannel();
                jsonArray = getChannelJsonArray(channelList);
            } else {
                jsonArray = getSubjectJsonArray(id);
            }

            modelAndView.addObject("resultData", jsonArray);
        } catch (Exception e) {
            log.info("Controller docTree exception", e);
        }

        return modelAndView;
    }

    public JsonArray getChannelJsonArray(List<ChannelBean> channelBeans) {
        JsonArray jsonArray = new JsonArray();
        for (ChannelBean channelBean : channelBeans) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", channelBean.getId());
            jsonObject.addProperty("name", channelBean.getName());
            jsonObject.addProperty("pid", 0);
            jsonObject.addProperty("isChannel", 0);
            List<SubjectBean> subjectBeanList = subjectService.getSubjectByPid((int) channelBean.getId());

            if (subjectBeanList != null && subjectBeanList.size() > 0) {
                jsonObject.addProperty("isParent", true);
            } else {
                jsonObject.addProperty("isParent", false);
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JsonArray getSubjectJsonArray(int pid) {
        JsonArray jsonArray = new JsonArray();
        List<SubjectBean> subjectBeanList = subjectService.getSubjectByPid(pid);

        for (SubjectBean subjectBean : subjectBeanList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", subjectBean.getId());
            jsonObject.addProperty("name", subjectBean.getName());
            jsonObject.addProperty("pid", pid);
            jsonObject.addProperty("isChannel", 1);

            List<SubjectBean> subjectBeanList1 = subjectService.getSubjectByPid((int) subjectBean.getId());
            if (subjectBeanList1 != null && subjectBeanList1.size() > 0) {

                jsonObject.addProperty("isParent", true);
            } else {
                jsonObject.addProperty("isParent", false);
            }
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

}
