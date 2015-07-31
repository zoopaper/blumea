package org.blumea.cms.service.token;


import org.blumea.cms.auth.AuthToken;
import org.blumea.cms.auth.Principal;

/**
 * 用户登录cookie加密解密处理接口
 */
public interface ITokenService {
    /**
     * 生成登录token
     *
     * @param principal 登录用户信息
     * @return 生成token
     */
    public AuthToken encodeToken(Principal principal);

    /**
     * 解析token，获取登录用户
     *
     * @param token token
     * @return 解析成功返回Principal，失败返回null
     */
    public Principal decodeToken(AuthToken token);
}
