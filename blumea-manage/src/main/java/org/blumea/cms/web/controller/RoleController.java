package org.blumea.cms.web.controller;

import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.RoleBean;
import org.blumea.cms.service.role.IRoleService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/6/24
 * Time: 22:23
 */
@Controller
@RequestMapping("/adm/role")
public class RoleController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);


    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/addRole", method = RequestMethod.GET)
    public ModelAndView addRole(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/role/addRole");
        return modelAndView;
    }

    @RequestMapping(value = "/doAddRole", method = RequestMethod.POST)
    public ModelAndView doAddRole(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String desc = ServletRequestUtils.getStringParameter(request, "description", "");
            String funcId = ServletRequestUtils.getStringParameter(request, "funcId", "");
            RoleBean roleBean = new RoleBean();
            {
                roleBean.setName(name);
                roleBean.setDescription(desc);
                roleBean.setFuncId(funcId);
                roleBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            roleService.addRole(roleBean);
        } catch (Exception e) {
            log.info("Controller doAddRole exception", e);
        }
        modelAndView.setViewName("redirect:/adm/role/roleList");
        return modelAndView;
    }

    @RequestMapping(value = "/roleList", method = RequestMethod.GET)
    public ModelAndView roleList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/role/roleList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");

            ServiceResponse<Pagination<RoleBean>> serviceResponse = roleService.getRoleWithPage(name, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("name", name);
        } catch (Exception e) {
            log.info("Controller roleList exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delRole", method = RequestMethod.GET)
    public ModelAndView deleteRole(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("redirect:/adm/role/roleList");

            String idArr = ServletRequestUtils.getStringParameter(request, "id");
            String[] ids = idArr.split(",");
            for (String id : ids) {
                roleService.deleteRole(Long.valueOf(id));
            }
        } catch (Exception e) {
            log.info("Controller delRole exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/toModifyRole", method = RequestMethod.GET)
    public ModelAndView toModifyRole(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            modelAndView.setViewName("/role/modifyRole");
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            RoleBean roleBean = roleService.getRole(id);
            if (roleBean != null) {
                modelAndView.addObject("role", roleBean);

            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifyRole exception", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/doModifyRole", method = RequestMethod.POST)
    public ModelAndView doModifyRole(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/role/roleList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String name = ServletRequestUtils.getStringParameter(request, "name", "");
            String desc = ServletRequestUtils.getStringParameter(request, "description", "");
            String funcId = ServletRequestUtils.getStringParameter(request, "funcId", "");
            RoleBean roleBean = new RoleBean();
            {
                roleBean.setId(id);
                roleBean.setName(name);
                roleBean.setDescription(desc);
                roleBean.setFuncId(funcId);
                roleBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }
            roleService.updateRole(roleBean);
        } catch (Exception e) {
            log.info("Controller doModifyRole exception", e);
        }
        return modelAndView;
    }


}
