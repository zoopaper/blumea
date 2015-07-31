package org.blumea.cms.web.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.channel.IChannelService;
import org.blumea.cms.service.subject.ISubjectService;
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
import org.blumea.cms.entity.ChannelBean;
import org.blumea.cms.entity.SubjectBean;
import org.blumea.cms.utils.ErrorKeyUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * 栏目管理
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/23
 * Time: 22:05
 */
@Controller
@RequestMapping("/adm/subject")
public class SubjectController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private IChannelService channelService;

    @RequestMapping(value = "/addSubject", method = RequestMethod.GET)
    public ModelAndView addSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        List<ChannelBean> channelList = channelService.getAllChannel();
        modelAndView.addObject("channelList", channelList);
        modelAndView.setViewName("/subject/addSubject");
        return modelAndView;
    }


    @RequestMapping(value = "/doAddSubject", method = RequestMethod.POST)
    public ModelAndView doAddSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String shortName = ServletRequestUtils.getStringParameter(request, "shortName", "");
            String tags = ServletRequestUtils.getStringParameter(request, "tags", "");
            String desc = ServletRequestUtils.getStringParameter(request, "desc", "");
            int channelId = ServletRequestUtils.getIntParameter(request, "channelId", 0);
            int status = ServletRequestUtils.getIntParameter(request, "status", 0);
            int priority = ServletRequestUtils.getIntParameter(request, "priority", 0);
            int pid = ServletRequestUtils.getIntParameter(request, "pid", 0);

            SubjectBean subject = new SubjectBean();
            {
                subject.setName(name);
                subject.setShortName(shortName);
                subject.setTags(tags);
                subject.setChannelId(channelId);
                subject.setStatus(status);
                subject.setDescription(desc);
                subject.setPid(pid);
                subject.setPriority(priority);
                subject.setCategory("");
                subject.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            subjectService.addSubject(subject);
        } catch (Exception e) {
            log.info("Controller doAddSubject exception", e);
        }
        modelAndView.setViewName("redirect:/adm/subject/subjectList");
        return modelAndView;
    }


    @RequestMapping(value = "/toModifySubject", method = RequestMethod.GET)
    public ModelAndView toModifySubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            List<ChannelBean> channelList = channelService.getAllChannel();
            modelAndView.addObject("channelList", channelList);
            modelAndView.setViewName("/subject/modifySubject");
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            SubjectBean subject = subjectService.getSubject(id);
            if (subject != null) {
                modelAndView.addObject("subject", subject);
            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifySubject exception", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/doModifySubject", method = RequestMethod.POST)
    public ModelAndView doModifySubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/subject/subjectList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String shortName = ServletRequestUtils.getStringParameter(request, "shortName", "");
            String tags = ServletRequestUtils.getStringParameter(request, "tags", "");
            String desc = ServletRequestUtils.getStringParameter(request, "desc", "");
            String oper = ServletRequestUtils.getStringParameter(request, "oper");
            int status = ServletRequestUtils.getIntParameter(request, "status", 0);
            int priority = ServletRequestUtils.getIntParameter(request, "priority", 1);
            int pid = ServletRequestUtils.getIntParameter(request, "pid", 0);
            String pname = ServletRequestUtils.getStringParameter(request, "pname", "");

            if (oper.equals("edit")) {
                SubjectBean subject = new SubjectBean();
                {
                    subject.setId(id);
                    subject.setName(name);
                    subject.setShortName(shortName);
                    subject.setTags(tags);
                    subject.setStatus(status);
                    subject.setDescription(desc);
                    subject.setPriority(priority);
                    subject.setCategory("");
                    subject.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                }
                subjectService.updateSubject(subject);
            } else if (oper.equals("add")) {
                SubjectBean subject = new SubjectBean();

                ChannelBean channelBean = channelService.getChannelByName(pname);
                if (null != channelBean) {
                    subject.setChannelId(channelBean.getId());
                } else {
                    SubjectBean subjectBean = subjectService.getSubjectByName(pname);
                    subject.setChannelId(subjectBean.getChannelId());
                }

                {

                    subject.setName(name);
                    subject.setShortName(shortName);
                    subject.setTags(tags);
                    subject.setStatus(status);
                    subject.setDescription(desc);
                    subject.setPriority(priority);
                    subject.setCategory("");
                    subject.setPid(pid);
                    subject.setCreateTime(new Timestamp(System.currentTimeMillis()));
                }
                subjectService.addSubject(subject);
            } else {
                subjectService.deleteSubject(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller doModifySubject exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    public ModelAndView subjectList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/subject/subjectList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String userName = ServletRequestUtils.getStringParameter(request, "name", "");

            ServiceResponse<Pagination<SubjectBean>> serviceResponse = subjectService.getSubjectWithPage(userName, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("page", serviceResponse.getResponseData());
            modelAndView.addObject("name", userName);
        } catch (Exception e) {
            log.info("Controller subjectList exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/subjectGrid", method = RequestMethod.POST)
    public ModelAndView subjectTreeList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/resultdata");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String userName = ServletRequestUtils.getStringParameter(request, "name", "");
            int pid = ServletRequestUtils.getIntParameter(request, "pid", 0);

            ServiceResponse<Pagination<SubjectBean>> serviceResponse = subjectService.getSubjectByPidWithPage(pid, userName, page, 100);
            subjectService.getSubjectByPid(pid);
            if (serviceResponse.isSuccess()) {
                if (serviceResponse.getResponseData().getItems() != null) {

                    String str = subject2Json(serviceResponse.getResponseData());
                    modelAndView.addObject("resultData", str);
                } else {
                    modelAndView.addObject("resultData", new JsonObject().toString());

                }
//                ResponseUtil.genJsonResult(modelAndView, serviceResponse.isSuccess(), "", ResponseUtil.ajaxGridResponse(serviceResponse.getResponseData()));
            } else {
                ResponseUtil.genJsonResult(modelAndView, serviceResponse.isSuccess(), ErrorKeyUtil.getErrorMsg(serviceResponse.getErrKey()), null);
            }
        } catch (Exception e) {
            log.info("Controller subjectGrid exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/delSubject", method = RequestMethod.GET)
    public ModelAndView deleteSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/subject/subjectList");

            String idArr = ServletRequestUtils.getStringParameter(request, "id");
            String[] ids = idArr.split(",");
            for (String id : ids) {
                subjectService.deleteSubject(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller delSubject exception", e);
        }
        return modelAndView;
    }


    public String subject2Json(Pagination<SubjectBean> pagination) {
        List<SubjectBean> subjectBeanList = pagination.getItems();

        JsonArray jsonArray = new JsonArray();
        for (SubjectBean subjectBean : subjectBeanList) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("shortName", subjectBean.getShortName());
            jsonObject.addProperty("name", subjectBean.getName());
            jsonObject.addProperty("channelName", subjectBean.getChannelName());
            jsonObject.addProperty("priority", subjectBean.getPriority());
            jsonObject.addProperty("status", subjectBean.getStatusStr());
            jsonObject.addProperty("id", subjectBean.getId());
            jsonObject.addProperty("channelId", subjectBean.getChannelId());
            jsonObject.addProperty("pid", subjectBean.getPid());
            jsonArray.add(jsonObject);
        }
//        JsonObject page = new JsonObject();
//        page.addProperty("page", pagination.getPageIndex());
//        JsonObject total = new JsonObject();
//        total.addProperty("total", pagination.getMaxPage());
//        JsonObject records = new JsonObject();
//        records.addProperty("records", pagination.getTotal());
//        jsonArray.add(page);
//        jsonArray.add(total);
//        jsonArray.add(records);
        return jsonArray.toString();
    }
}
