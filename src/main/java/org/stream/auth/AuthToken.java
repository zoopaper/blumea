package org.stream.auth;

/**
 * 用户认证Token
 * <p/>
 * User: zhangchao@mail-inc.com
 * Date: 12-4-1
 * Time: 下午6:51
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
