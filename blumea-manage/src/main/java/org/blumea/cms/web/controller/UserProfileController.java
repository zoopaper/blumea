package org.blumea.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: shijingui
 * Date: 2016/2/5
 */
@Controller
public class UserProfileController extends BaseController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("config/user_profile");
        return modelAndView;
    }
}
