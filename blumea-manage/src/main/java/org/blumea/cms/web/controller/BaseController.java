package org.blumea.cms.web.controller;

import net.common.utils.cookie.CookieUtil;
import org.blumea.cms.constants.token.TokenConstant;
import org.blumea.cms.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.blumea.cms.auth.AuthToken;
import org.blumea.cms.auth.Principal;

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
