package org.blumea.cms.web.util;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import net.common.utils.escapehtml.StdEscapeHTMLSerializerProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.BasicClassIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.blumea.cms.model.FlexigridData;
import org.blumea.cms.model.Pagination;

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
     * JSON序列化工具(html转码)
     */
    private static final ObjectMapper ESCAPEHTML_SERIALIZER = createObjectMap();
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


    /**
     * 构造分页Ajax响应数据
     *
     * @param page
     * @param <T>
     * @return JSON串
     * @throws java.io.IOException
     */
    public static <T> String ajaxGridResponse(Pagination<T> page) throws Exception {
        if (page == null) {
            throw new NullPointerException();
        }
        FlexigridData<T> data = new FlexigridData<>();
        data.setPage(page.getPageIndex());
        data.setTotal(page.getTotal());
        data.setRows(page.getItems());
        return JSON.toJSONString(data);
//        return ESCAPEHTML_SERIALIZER.writeValueAsString(data);
    }

    /**
     * 构建html转码用Json序列化器
     *
     * @return
     */
    private static ObjectMapper createObjectMap() {
        try {
            SerializationConfig serializationConfig = new SerializationConfig(BasicClassIntrospector.instance, new JacksonAnnotationIntrospector(), VisibilityChecker.Std.defaultInstance(),
                    null, null, TypeFactory.defaultInstance(), null);
            StdEscapeHTMLSerializerProvider stdEscapeHTMLSerializerProvider = new StdEscapeHTMLSerializerProvider(serializationConfig);
            return new ObjectMapper(null, stdEscapeHTMLSerializerProvider, null);
        } catch (Exception e) {
            log.error("init StdEscapeHTMLSerializerProvider failed!");
        }
        return null;
    }

    /**
     * 生成标准响应json数据
     *
     * @param modelAndView
     * @param resultFlag
     * @param message
     * @param jsonData
     */
    public static void genJsonResult(ModelAndView modelAndView, boolean resultFlag, String message, String jsonData) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(JSON_KEY_RESPONSE_RESULT, resultFlag);
            if (!Strings.isNullOrEmpty(message)) {
                jsonObject.put(JSON_KEY_RESPONSE_MSG, message);
            }
            if (!Strings.isNullOrEmpty(jsonData)) {
                JSONObject dataJsonObject = new JSONObject(jsonData);
                jsonObject.put(JSON_KEY_RESPONSE_DATA, dataJsonObject);
            }
            modelAndView.addObject("resultData", jsonObject);
            modelAndView.setViewName("/common/resultdata");
        } catch (JSONException e) {
            log.error("genJsonResult json format error : {}", jsonData, e);
        }
    }

}