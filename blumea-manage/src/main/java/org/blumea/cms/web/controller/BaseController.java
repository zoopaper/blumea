package org.blumea.cms.web.controller;

import net.common.utils.cookie.CookieUtil;
import org.blumea.cms.auth.AuthToken;
import org.blumea.cms.auth.Principal;
import org.blumea.cms.constants.token.TokenConstant;
import org.blumea.cms.service.auth.IAuthService;
import org.blumea.cms.utils.PageData;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:25
 */
@Component
public class BaseController {

    @Resource
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


    /**
     * 封装请求数据
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
