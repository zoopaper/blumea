package org.blumea.cms.web.controller;

import org.blumea.cms.web.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.blumea.cms.auth.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:24
 */
@Controller
@RequestMapping("/*")
public class HomeController extends BaseController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            Principal principal = this.getLoginPrincipal(request);
            if (principal == null) {
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
        } catch (Exception e) {
        }


        modelAndView.setViewName("/main/main");
        return modelAndView;

    }
}
