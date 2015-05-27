package org.stream.web.controller;

import net.common.utils.cookie.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.stream.auth.AuthToken;
import org.stream.auth.Principal;
import org.stream.constants.token.TokenConstant;
import org.stream.service.auth.IAuthService;
import org.stream.web.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:25
 */
@Controller
public class BaseController {

    @Autowired
    private IAuthService authService;


    protected final AuthToken buildAuthToken(Principal principal) {
        return authService.buildToken(principal);
    }


    protected final Principal getLoginPrincipal(HttpServletRequest request) {
        String cookieName = TokenConstant.USER_COOKIE_NAME;
        String cookie = CookieUtil.getCookie(request, cookieName);
        AuthToken token = new AuthToken();
        token.setCookie(cookie);
        return authService.authenticate(token);
    }

    /**
     * 初始化spring mvc的数据绑定
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 对字符串类型进行trim操作
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(null, false));
    }


}
