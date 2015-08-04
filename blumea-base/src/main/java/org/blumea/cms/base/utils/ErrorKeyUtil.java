package org.blumea.cms.base.utils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.blumea.cms.base.constants.error.ErrorKey;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误信息
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/27
 * Time: 15:03
 */
public final class ErrorKeyUtil {

    private static final Map<Integer, String> errorMap = new HashMap<Integer, String>();

    private ErrorKeyUtil() {
    }

    static {
        init();
    }

    private static void init() {
        put(ErrorKey.ERROR_LOGIN_ACCOUNT_EMPTY, "账号不能为空");
        put(ErrorKey.ERROR_LOGIN_PASSWORD_EMPTY, "密码不能为空");
        put(ErrorKey.ERROR_LOGIN_ACCOUNT_NOT_EXIST, "账户不存在");
        put(ErrorKey.ERROR_LOGIN_PASSWORD_INCORRECT, "登录密码不正确");
        put(ErrorKey.ERROR_CHANNEL_NAME_REPEAT, "频道名称不能重复");

    }


    private static void put(Integer errKey, String errMsg) {
        Preconditions.checkState(!errorMap.containsKey(errKey), "ErrKey already exists in the map. key=" + errKey);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(errMsg), "ErrMsg cannot be empty or null. key=" + errKey);
        errorMap.put(errKey, errMsg);
    }

    public static String getErrorMsg(int errKey) {
        return errorMap.get(errKey);
    }
}
