package org.blumea.cms.base.auth;

/**
 * 用户认证Token
 * <p/>
 * User: krisibm@163.com
 */
public class AuthToken {
    /**
     * 用户cookie
     */
    private String cookie;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
