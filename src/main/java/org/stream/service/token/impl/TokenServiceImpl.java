package org.stream.service.token.impl;


import com.google.common.base.Strings;
import net.common.utils.encrypt.DesEncrypterUtil;
import org.springframework.stereotype.Service;
import org.stream.auth.AuthToken;
import org.stream.auth.Principal;
import org.stream.constants.token.TokenConstant;
import org.stream.service.token.ITokenService;

import java.util.Random;

/**
 * 用户登录cookie加密解密处理
 */
@Service
public class TokenServiceImpl implements ITokenService {

    /**
     * 加密解密器
     */
    private static DesEncrypterUtil encrypter;

    public static final Random RANDOM = new Random();

    static {
        init();
    }

    public static void init() {
        encrypter = new DesEncrypterUtil(TokenConstant.PASSPHRASE);
    }

    /**
     * 生成登录token
     *
     * @param principal 登录用户信息
     * @return 认证token
     */
    @Override
    public AuthToken encodeToken(Principal principal) {
        StringBuilder builder = new StringBuilder();
        builder.append(RANDOM.nextInt())
                .append(TokenConstant.SPLIT_CHAR)
                .append(principal.getUserId())
                .append(TokenConstant.SPLIT_CHAR)
                .append(principal.getType())
                .append(TokenConstant.SPLIT_CHAR)
                .append(System.currentTimeMillis());
        String cookie = encrypter.encrypt(builder.toString());
        AuthToken token = new AuthToken();
        token.setCookie(cookie);
        return token;
    }

    /**
     * 解析token,获取登录用户
     *
     * @param token 认证token
     * @return 解析成功返回Principal，失败返回null
     */
    @Override
    public Principal decodeToken(AuthToken token) {
        if (token == null) {
            return null;
        }

        String cookie = token.getCookie();
        if (Strings.isNullOrEmpty(cookie)) {
            return null;
        }

        String decodeToken = encrypter.decrypt(cookie);
        if (Strings.isNullOrEmpty(decodeToken)) {
            return null;
        }
        String[] values = decodeToken.split(TokenConstant.SPLIT_CHAR);

        if (null == values || values.length != 4) {
            return null;
        }
        Principal principal = new Principal();
        principal.setUserId(Long.parseLong(values[1]));
        principal.setType(Integer.parseInt(values[2]));
        principal.setTimestamp(Long.parseLong(values[3]));
        return principal;
    }
}
