package org.blumea.cms.web.controller;

import com.google.common.base.Strings;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.constants.error.ErrorKey;
import org.blumea.cms.entity.ChannelBean;
import org.blumea.cms.entity.SubjectBean;
import org.blumea.cms.service.channel.IChannelService;
import org.blumea.cms.service.subject.ISubjectService;
import org.blumea.cms.utils.ErrorKeyUtil;
import org.blumea.cms.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * 频道管理
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:03
 */
@Controller
@RequestMapping("/adm/channel")
public class ChannelController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private ISubjectService subjectService;


    @RequestMapping(value = "/addChannel", method = RequestMethod.GET)
    public ModelAndView addChannel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/channel/addChannel");
        return modelAndView;
    }

    @RequestMapping(value = "/doAddChannel", method = RequestMethod.POST)
    public ModelAndView doAddChannel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String dir = ServletRequestUtils.getStringParameter(request, "dir", "");

            if (!Strings.isNullOrEmpty(name)) {
                ChannelBean channelBean = channelService.getChannelByName(name);
                if (null != channelBean) {
                    modelAndView.setViewName("/channel/addChannel");
                    modelAndView.addObject("errTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_CHANNEL_NAME_REPEAT));
                    return modelAndView;
                }
            }

            ChannelBean channelBean = new ChannelBean();
            {
                channelBean.setName(name);
                channelBean.setDir(dir);
                channelBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            channelService.addChanel(channelBean);
        } catch (Exception e) {
            log.info("Controller doAddChannel exception", e);
        }
        modelAndView.setViewName("redirect:/adm/channel/channelList");
        return modelAndView;
    }


    @RequestMapping(value = "/channelList", method = RequestMethod.GET)
    public ModelAndView channelList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/channel/channelList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            List<ChannelBean> channelList = channelService.getAllChannel();
            modelAndView.addObject("channelList", channelList);
        } catch (Exception e) {
            log.info("Controller channelList exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/toChannelTree", method = RequestMethod.GET)
    public ModelAndView toChannelTree(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/channel/channelTree");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

        } catch (Exception e) {
            log.info("Controller toChannelTree exception", e);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/channelTree", method = RequestMethod.POST)
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
            log.info("Controller channelList exception", e);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/delChannel", method = RequestMethod.GET)
    public ModelAndView delChannel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/channel/channelList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            channelService.deleteChannel(id);
        } catch (Exception e) {
            log.info("Controller delChannel exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/toModifyChannel", method = RequestMethod.GET)
    public ModelAndView toModifyChannel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/channel/modifyChannel");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            ChannelBean channelBean = channelService.getChannel(id);
            if (channelBean != null) {
                modelAndView.addObject("channel", channelBean);
            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifyChannel exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/doModifyChannel", method = RequestMethod.POST)
    public ModelAndView doModifyChannel(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/channel/channelList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String dir = ServletRequestUtils.getStringParameter(request, "dir", "");

            ChannelBean channelBean = new ChannelBean();
            {
                channelBean.setId(id);
                channelBean.setName(name);
                channelBean.setDir(dir);
            }
            channelService.updateChannel(channelBean);
        } catch (Exception e) {
            log.info("Controller doModifyChannel exception", e);
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
            jsonObject.addProperty("channelId", channelBean.getId());
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
            jsonObject.addProperty("channelId", -1);

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
