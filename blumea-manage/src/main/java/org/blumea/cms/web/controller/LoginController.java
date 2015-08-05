package org.blumea.cms.web.controller;

import com.google.common.base.Strings;
import net.common.utils.cookie.CookieUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.blumea.cms.auth.AuthToken;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.constants.error.ErrorKey;
import org.blumea.cms.constants.token.TokenConstant;
import org.blumea.cms.entity.UserBean;
import org.blumea.cms.service.user.IUserService;
import org.blumea.cms.utils.ErrorKeyUtil;
import org.blumea.cms.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:48
 */
@Controller
@RequestMapping("/adm/*")
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    private String COOKIE_USER_NAME = "USERNAME";

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView jumpLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseUtil.handleLongin(modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestParam(value = "account", required = true) String account,
                                @RequestParam(value = "password", required = true) String password,
                                HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            if (Strings.isNullOrEmpty(account)) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_ACCOUNT_EMPTY));
                modelAndView.addObject("password", password);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            if (Strings.isNullOrEmpty(password)) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_PASSWORD_EMPTY));
                modelAndView.addObject("account", account);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            UserBean userBean = userService.getUserByAccount(account);
            if (userBean == null) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_ACCOUNT_NOT_EXIST));
                modelAndView.addObject("password", password);
                modelAndView.addObject("account", account);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            String passwd = DigestUtils.md5Hex(password);
            if (!userBean.getPassword().equals(passwd)) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_PASSWORD_INCORRECT));
                modelAndView.addObject("password", password);
                modelAndView.addObject("account", account);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            Principal principal = new Principal();
            principal.setUserId(userBean.getId());
            AuthToken token = buildAuthToken(principal);
            CookieUtil.setTokenCookie(response, TokenConstant.USER_COOKIE_NAME, token.getCookie(), TokenConstant.TOKEN_LIFE_TIME, "");
            CookieUtil.setTokenCookie(response, COOKIE_USER_NAME, userBean.getAccount(), TokenConstant.TOKEN_LIFE_TIME, "");
            modelAndView.setViewName("redirect:/adm/channel/toChannelTree");
        } catch (Exception e) {
            log.info("doLogin controller exception ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/adm/login");
        try {
            CookieUtil.removeCookie(response, TokenConstant.USER_COOKIE_NAME, "");
        } catch (Exception e) {
            log.info("Controller logout exception", e);
        }
        return modelAndView;

    }

}
