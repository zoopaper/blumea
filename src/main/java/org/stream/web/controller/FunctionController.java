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
import org.stream.entity.FunctionBean;
import org.stream.model.Pagination;
import org.stream.service.function.IFunctionService;
import org.stream.web.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/25
 * Time: 21:08
 */
@Controller
@RequestMapping("/adm/function")
public class FunctionController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    private IFunctionService functionService;

    @RequestMapping(value = "/addFunction", method = RequestMethod.GET)
    public ModelAndView addFunction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/function/addFunction");
        return modelAndView;
    }

    @RequestMapping(value = "/doAddFunction", method = RequestMethod.POST)
    public ModelAndView doAddFunction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String action = ServletRequestUtils.getStringParameter(request, "action", "");
            String param = ServletRequestUtils.getStringParameter(request, "param", "");
            int isGroup = ServletRequestUtils.getIntParameter(request, "isGroup", 0);
            FunctionBean functionBean = new FunctionBean();
            {
                functionBean.setName(name);
                functionBean.setAction(action);
                functionBean.setParam(param);
                functionBean.setIsGroup(isGroup);
                functionBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            functionService.addFunction(functionBean);
        } catch (Exception e) {
            log.info("Controller doAddFunction exception", e);
        }
        modelAndView.setViewName("redirect:/adm/function/functionList");
        return modelAndView;
    }

    @RequestMapping(value = "/functionList", method = RequestMethod.GET)
    public ModelAndView functionList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/function/functionList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");

            ServiceResponse<Pagination<FunctionBean>> serviceResponse = functionService.getFunctionWithPage(name, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("name", name);
        } catch (Exception e) {
            log.info("Controller functionList exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delFunction", method = RequestMethod.GET)
    public ModelAndView delFunction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/function/functionList");

            String[] idArr = ServletRequestUtils.getStringParameters(request, "id");

            for (String id : idArr) {
                functionService.deleteFunction(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller delFunction exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/toModifyFunction", method = RequestMethod.GET)
    public ModelAndView toModifyFunction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("/function/modifyFunction");
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            FunctionBean function = functionService.getFunction(id);
            if (function != null) {
                modelAndView.addObject("function", function);

            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifyFunction exception", e);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/doModifyFunction", method = RequestMethod.POST)
    public ModelAndView doModifyFunction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/function/functionList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String action = ServletRequestUtils.getStringParameter(request, "action", "");
            String param = ServletRequestUtils.getStringParameter(request, "param", "");
            int isGroup = ServletRequestUtils.getIntParameter(request, "isGroup", 0);
            FunctionBean functionBean = new FunctionBean();
            {
                functionBean.setId(id);
                functionBean.setName(name);
                functionBean.setAction(action);
                functionBean.setParam(param);
                functionBean.setIsGroup(isGroup);
                functionBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            functionService.updateFunction(functionBean);
        } catch (Exception e) {
            log.info("Controller doModifyFunction exception", e);
        }
        return modelAndView;
    }


}
