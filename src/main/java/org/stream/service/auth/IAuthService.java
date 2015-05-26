package org.stream.service.auth;

import org.stream.auth.AuthToken;
import org.stream.auth.Principal;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 12:48
 */
public interface IAuthService {

    /**
     * 认证是否为合法用户
     *
     * @param token 当前用户持有的认证token
     * @return 合法返回用户主体对象，反之返回null
     */
    Principal authenticate(AuthToken token);

    /**
     * 根据用户主体生成认证token
     *
     * @param principal 用户主体
     * @return 认证token
     */
    AuthToken buildToken(Principal principal);
}
