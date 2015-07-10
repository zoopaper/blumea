package org.stream.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.stream.auth.Principal;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.SubjectBean;
import org.stream.model.Pagination;
import org.stream.service.subject.ISubjectService;
import org.stream.web.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

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

    @RequestMapping(value = "/addSubject", method = RequestMethod.GET)
    public ModelAndView addSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
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
            int channelId = ServletRequestUtils.getIntParameter(request, "channelId", -1);
            int status = ServletRequestUtils.getIntParameter(request, "status", -1);
            int priority = ServletRequestUtils.getIntParameter(request, "priority", -1);
            int pid = ServletRequestUtils.getIntParameter(request, "pid", -1);

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
            int channelId = ServletRequestUtils.getIntParameter(request, "channelId", -1);
            int status = ServletRequestUtils.getIntParameter(request, "status", -1);
            int priority = ServletRequestUtils.getIntParameter(request, "priority", -1);
            int pid = ServletRequestUtils.getIntParameter(request, "pid", -1);

            SubjectBean subject = new SubjectBean();
            {
                subject.setId(id);
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
            subjectService.updateSubject(subject);
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

}
