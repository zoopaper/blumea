package org.stream.service.auth.impl;

import org.springframework.stereotype.Service;
import org.stream.auth.AuthToken;
import org.stream.auth.Principal;
import org.stream.service.auth.IAuthService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:28
 */
@Service
public class UserAuthServiceImpl implements IAuthService {

    @Override
    public Principal authenticate(AuthToken token) {
        return null;
    }

    @Override
    public AuthToken buildToken(Principal principal) {
        return null;
    }

}
