package org.stream.constants.token;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 13:44
 */
public class TokenConstant {

    private TokenConstant() {

    }

    /**
     * 加密key保存文件
     */
    public static final String ENCRYPT_PASSPHRASE_FILE = "encrypt.conf.xml";

    /**
     * 加密解密器密钥
     */
    public static final String ENCRYPT_CONFIG = "encrypt.passphrase";

    /**
     * 加密解密器密钥绑定名称
     */
    public static final String ENCRYPT_CONFIG_KEY_NAME = "encrypt.key";


    /**
     * 分隔符
     */
    public static final String SPLIT_CHAR = "_";

    /**
     * Token失效时间 : 24小时
     */
    public static final int TOKEN_LIFE_TIME = 60 * 60 * 24;

    /**
     * 加密解密器密钥默认值
     */
    public static final String PASSPHRASE = "gs7n$en76$3@ad1s";

    public static final String USER_COOKIE_NAME = "USER";

}
