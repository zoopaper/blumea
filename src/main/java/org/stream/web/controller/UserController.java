package org.stream.web.controller;

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

//    @RequestMapping(value = "/userList", method = RequestMethod.GET)
//    public ModelAndView userList(HttpServletRequest request, HttpServletResponse response) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/userList");
//
//        return modelAndView;
//    }

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
            String passwd = DigestUtils.md5Hex(password);
            UserBean userBean = new UserBean();
            {
                userBean.setAccount(account);
                userBean.setUserName(userName);
                userBean.setPassword(passwd);
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

        } catch (Exception e) {
            log.info("Controller userList exception", e);
        }
        return modelAndView;
    }


}
