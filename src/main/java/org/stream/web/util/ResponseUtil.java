package org.stream.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 21:51
 */
public class ResponseUtil {

    private static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);

    public static final String MAPPING_LOGIN = "/login/login";

    /**
     * Mapping:异常
     */
    public static final String MAPPING_ERROR = "/err/systemErr";

    /**
     * Mapping:无权
     */
    public static final String MAPPING_NO_PERMISSION = "/err/purviewErr";

    /**
     * 标准http响应请求协议的key ： 结果标识
     */
    public static final String JSON_KEY_RESPONSE_RESULT = "result";
    /**
     * 标准http响应请求协议的key ： 错误消息
     */
    public static final String JSON_KEY_RESPONSE_MSG = "msg";
    /**
     * 标准http响应请求协议的key ： 数据
     */
    public static final String JSON_KEY_RESPONSE_DATA = "data";

    private ResponseUtil() {
    }


    /**
     * 未登录处理：
     *
     * @param modelAndView
     */
    public static void handleLongin(ModelAndView modelAndView) {
        modelAndView.setViewName(MAPPING_LOGIN);
    }


    /**
     * 失败处理：
     *
     * @param modelAndView
     */
    public static void handleExeception(ModelAndView modelAndView) {
        modelAndView.setViewName(MAPPING_ERROR);
    }


    /**
     * 无权限处理：
     *
     * @param modelAndView
     */
    public static void handleNoPermission(ModelAndView modelAndView) {
        modelAndView.setViewName(MAPPING_NO_PERMISSION);
    }


}
