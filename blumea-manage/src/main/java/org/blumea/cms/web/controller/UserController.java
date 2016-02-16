package org.blumea.cms.web.controller;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.config.AppConfigContext;
import org.blumea.cms.core.model.ServiceResponse;
import org.blumea.cms.entity.UserEntity;
import org.blumea.cms.model.Pagination;
import org.blumea.cms.service.user.IUserService;
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
import java.util.Date;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/25
 * Time: 22:24
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private AppConfigContext loadConf;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/doAddUser", method = RequestMethod.POST)
    public ModelAndView doAddUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            String userName = ServletRequestUtils.getStringParameter(request, "username", "");
            String account = ServletRequestUtils.getStringParameter(request, "account", "");
            String password = ServletRequestUtils.getStringParameter(request, "password", "");
            String email = ServletRequestUtils.getStringParameter(request, "email", "");

            String passwd = DigestUtils.md5Hex(password);

            UserEntity userEntity = new UserEntity();
            {
                userEntity.setAccount(account);
                userEntity.setUsername(userName);
                userEntity.setPassword(passwd);
                userEntity.setEmail(email);
                userEntity.setCreateTime(new Date(System.currentTimeMillis()));
            }

            userService.addUser(userEntity);
        } catch (Exception e) {
            log.info("Controller doAddUser exception", e);
        }
        modelAndView.setViewName("redirect:/adm/user/userList");
        return modelAndView;
    }


    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            int page = ServletRequestUtils.getIntParameter(request, "page", 1);
            String userName = ServletRequestUtils.getStringParameter(request, "userName", "");

            ServiceResponse<Pagination<UserEntity>> serviceResponse = userService.getUserWithPage(userName, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("userName", userName);
        } catch (Exception e) {
            log.info("Controller userList exception", e);
        }

        String s = loadConf.getString("redis.timeout", "");
        String domain = loadConf.getString("static.conf.domain", "");
        return modelAndView;
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/user/userList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }

            String[] idArr = ServletRequestUtils.getStringParameters(request, "id");

            String ids = "";
            if (idArr != null || idArr.length > 0) {
                ids = Joiner.on(",").join(idArr);
            }
            userService.deleteUser(ids);
        } catch (Exception e) {
            log.info("Controller delUser exception", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/toModifyUser", method = RequestMethod.GET)
    public ModelAndView toModifyUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/modifyUser");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            UserEntity userEntity = userService.getUser(id);
            if (userEntity != null) {
                modelAndView.addObject("user", userEntity);

            } else {
                modelAndView.addObject("error", "操作出问题了!");
                modelAndView.setViewName("/common/error");
            }
        } catch (Exception e) {
            log.info("Controller toModifyUser exception", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/doModifyUser", method = RequestMethod.POST)
    public ModelAndView doModifyUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/user/userList");
        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            long id = ServletRequestUtils.getLongParameter(request, "id", -1);
            String userName = ServletRequestUtils.getStringParameter(request, "userName", "");
            String account = ServletRequestUtils.getStringParameter(request, "account", "");
            String email = ServletRequestUtils.getStringParameter(request, "email", "");
            UserEntity userEntity = new UserEntity();
            {
                userEntity.setId(id);
                userEntity.setAccount(account);
                userEntity.setUsername(userName);
                userEntity.setEmail(email);
                userEntity.setCreateTime(new Date(System.currentTimeMillis()));
            }
            userService.updateUser(userEntity);
        } catch (Exception e) {
            log.info("Controller doModifyUser exception", e);
        }
        return modelAndView;
    }

    public AppConfigContext getLoadConf() {
        return loadConf;
    }

    public void setLoadConf(AppConfigContext loadConf) {
        this.loadConf = loadConf;
    }
}
