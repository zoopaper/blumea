package org.stream.service.auth.impl;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stream.auth.AuthToken;
import org.stream.auth.Principal;
import org.stream.entity.UserBean;
import org.stream.service.auth.IAuthService;
import org.stream.service.token.ITokenService;
import org.stream.service.user.IUserService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:28
 */
@Service
public class UserAuthServiceImpl implements IAuthService {

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IUserService userService;

    @Override
    public Principal authenticate(AuthToken token) {
        Preconditions.checkNotNull(token, "auth token can not be null");
        Principal principal = tokenService.decodeToken(token);
        if (principal == null) {
            return null;
        }
        long userId = principal.getUserId();
        // 不是合法的认证token，返回null
        if (userId <= 0) {
            return null;
        }
        // 如果当前用户不存在于数据库中，返回null
        UserBean adminBean = userService.getUser(userId);
        if (adminBean == null) {
            return null;
        }
        return principal;
    }

    @Override
    public AuthToken buildToken(Principal principal) {
        Preconditions.checkNotNull(principal, "principal can not be null");
        long userId = principal.getUserId();
        Preconditions.checkArgument(userId > 0, "illegal user id %s", userId);
        return tokenService.encodeToken(principal);
    }

}
