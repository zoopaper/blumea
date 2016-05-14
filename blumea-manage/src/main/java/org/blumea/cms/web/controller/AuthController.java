package org.blumea.cms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/6/25
 * Time: 22:56
 */
@Controller
@RequestMapping("/adm/auth")
public class AuthController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/auth/auth");
        return modelAndView;
    }

}
