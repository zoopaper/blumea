package org.stream.web.controller;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.stream.auth.Principal;
import org.stream.config.AppConfigContext;
import org.stream.core.model.ServiceResponse;
import org.stream.entity.UserBean;
import org.stream.model.Pagination;
import org.stream.service.user.IUserService;
import org.stream.web.util.ResponseUtil;

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
@RequestMapping("/adm/user")
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

            String userName = ServletRequestUtils.getStringParameter(request, "userName", "");
            String account = ServletRequestUtils.getStringParameter(request, "account", "");
            String password = ServletRequestUtils.getStringParameter(request, "password", "");
            String email = ServletRequestUtils.getStringParameter(request, "email", "");
            int age = ServletRequestUtils.getIntParameter(request, "age", 100);
            int sex = ServletRequestUtils.getIntParameter(request, "sex", 0);
            String city = ServletRequestUtils.getStringParameter(request, "city", "");
            String work = ServletRequestUtils.getStringParameter(request, "work", "");
            String workYear = ServletRequestUtils.getStringParameter(request, "workYear", "");
            String mobileTel = ServletRequestUtils.getStringParameter(request, "mobileTel", "");

            String passwd = DigestUtils.md5Hex(password);

            UserBean userBean = new UserBean();
            {
                userBean.setAccount(account);
                userBean.setUserName(userName);
                userBean.setPassword(passwd);
                userBean.setAge(age);
                userBean.setSex(sex);
                userBean.setCity(city);
                userBean.setEmail(email);
                userBean.setWork(work);
                userBean.setWorkYear(workYear);
                userBean.setMobileTel(mobileTel);
                userBean.setCreateDate(new Date(System.currentTimeMillis()));
            }

            userService.addUser(userBean);
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

            ServiceResponse<Pagination<UserBean>> serviceResponse = userService.getUserWithPage(userName, page, 15);

            if (serviceResponse.isSuccess()) {
                modelAndView.addObject("page", serviceResponse.getResponseData());
            }
            modelAndView.addObject("userName", userName);
        } catch (Exception e) {
            log.info("Controller userList exception", e);
        }

        String s = loadConf.getString("redis.timeout", "");

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
            UserBean userBean = userService.getUser(id);
            if (userBean != null) {
                modelAndView.addObject("user", userBean);

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
            int age = ServletRequestUtils.getIntParameter(request, "age", 100);
            int sex = ServletRequestUtils.getIntParameter(request, "sex", 0);
            String city = ServletRequestUtils.getStringParameter(request, "city", "");
            String work = ServletRequestUtils.getStringParameter(request, "work", "");
            String workYear = ServletRequestUtils.getStringParameter(request, "workYear", "");
            String mobileTel = ServletRequestUtils.getStringParameter(request, "mobileTel", "");


            UserBean userBean = new UserBean();
            {
                userBean.setId(id);
                userBean.setAccount(account);
                userBean.setUserName(userName);
                userBean.setAge(age);
                userBean.setSex(sex);
                userBean.setCity(city);
                userBean.setEmail(email);
                userBean.setWork(work);
                userBean.setWorkYear(workYear);
                userBean.setMobileTel(mobileTel);
                userBean.setCreateDate(new Date(System.currentTimeMillis()));
            }
            userService.updateUser(userBean);
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
