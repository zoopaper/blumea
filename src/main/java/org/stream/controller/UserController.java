package org.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.stream.entity.User;
import org.stream.service.IUserService;

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
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/adminList", method = RequestMethod.GET)
    public ModelAndView userList(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView doAddUser(HttpServletRequest request, HttpServletResponse response) {


        String userName = ServletRequestUtils.getStringParameter(request, "userName", "");
        String account = ServletRequestUtils.getStringParameter(request, "account", "");
        String password = ServletRequestUtils.getStringParameter(request, "password", "");
        User user = new User();
        {
            user.setAccount(account);
            user.setUserName(userName);
            user.setPassword(password);
            user.setCreateDate(new Date(System.currentTimeMillis()));
        }

        userService.addUser(user);

        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }


}
