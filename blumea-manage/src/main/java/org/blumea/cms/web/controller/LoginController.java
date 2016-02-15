package org.blumea.cms.web.controller;

import net.common.utils.cookie.CookieUtil;
import net.common.utils.json.JsonWrite;
import org.apache.commons.codec.digest.DigestUtils;
import org.blumea.cms.auth.AuthToken;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.constants.error.ErrorKey;
import org.blumea.cms.constants.token.TokenConstant;
import org.blumea.cms.entity.UserEntity;
import org.blumea.cms.service.user.IUserService;
import org.blumea.cms.utils.ErrorKeyUtil;
import org.blumea.cms.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User : shijingui
 * Date: 2015/5/26
 * Time: 21:48
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private IUserService userService;

    private String COOKIE_USER_NAME = "USERNAME";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView jumpLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseUtil.handleLongin(modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(UserEntity userEntity) {
        JsonWrite jsonWrite = new JsonWrite();

        return jsonWrite;
    }

    @RequestMapping(value = "/doLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView doLogin(@RequestParam(value = "account", required = true) String account,
                                @RequestParam(value = "password", required = true) String password,
                                HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            UserEntity userEntity = userService.getUserByAccount(account);
            if (userEntity == null) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_ACCOUNT_NOT_EXIST));
                modelAndView.addObject("password", password);
                modelAndView.addObject("username", account);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            String passwd = DigestUtils.md5Hex(password);
            if (!userEntity.getPassword().equals(passwd)) {
                modelAndView.addObject("loginTip", ErrorKeyUtil.getErrorMsg(ErrorKey.ERROR_LOGIN_PASSWORD_INCORRECT));
                modelAndView.addObject("password", password);
                modelAndView.addObject("account", account);
                ResponseUtil.handleLongin(modelAndView);
                return modelAndView;
            }
            Principal principal = new Principal();
            principal.setUserId(userEntity.getId());
            principal.setAccount(userEntity.getAccount());
            AuthToken token = buildAuthToken(principal);
            CookieUtil.setTokenCookie(response, TokenConstant.USER_COOKIE_NAME, token.getCookie(), TokenConstant.TOKEN_LIFE_TIME, "");
            CookieUtil.setTokenCookie(response, COOKIE_USER_NAME, userEntity.getAccount(), TokenConstant.TOKEN_LIFE_TIME, "");
            modelAndView.setViewName("redirect:/index");
        } catch (Exception e) {
            log.info("doLogin controller exception ", e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        HttpServletRequest request = this.getRequest();
        Principal principal = this.getLoginPrincipal(this.getRequest());
        Cookie[] cookies = request.getCookies();
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        try {
            CookieUtil.removeCookie(response, TokenConstant.USER_COOKIE_NAME, "");
        } catch (Exception e) {
            log.info("Controller logout exception", e);
        }
        return modelAndView;
    }


}
