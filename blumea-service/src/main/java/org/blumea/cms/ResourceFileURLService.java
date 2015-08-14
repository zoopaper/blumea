package org.blumea.cms;

import com.google.common.base.Preconditions;
import org.blumea.cms.service.staticres.IStaticResCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将资源文件 (暂时是JS, CSS, JPG格式的图片) 的地址从数据库中保存的开发地址转换为线上地址的工具类
 */
@Service
public  class ResourceFileURLService {
    /**
     * 默认的JPG格式图片域名
     */
    private static final String JPG_DEFAULT_DOMAIN = "eleword.net";
    /**
     * 默认的JS域名
     */
    private static final String JS_DEFAULT_DOMAIN = "eleword.net";
    /**
     * 默认的CSS域名
     */
    private static final String CSS_DEFAULT_DOMAIN = "eleword.net";
    /**
     * css的正则表达式模式
     */
    private static final Pattern CSS_URL_PATTERN = Pattern.compile("http://(.+?)/(.+)\\.(css)");
    /**
     * js的正则表达式模式
     */
    private static final Pattern JS_URL_PATTERN = Pattern.compile("http://(.+?)/(.+)\\.(js)");
    /**
     * jpg格式图片的正则表达式模式
     */
    private static final Pattern JPG_URL_PATTERN = Pattern.compile("http://(.+?)/(.+)\\.(jpg)");
    /**
     * js源代码发布的前缀
     */
    private static final String J_SRC_PREFIX = "js";

    /**
     * js打包发布的前缀
     */
    private static final String J_PREFIX = "j";

    /**
     * css资源配置信息
     */
    private static Map<String, String> cssResCfgMap;

    /**
     * js资源配置信息
     */
    private static Map<String, String> jsResCfgMap;

    /**
     * 公共css资源配置信息
     */
    private static Map<String, String> cssResCommMap;

    /**
     * 公共js资源配置信息
     */
    private static Map<String, String> jsResCommMap;

    @Autowired
    private IStaticResCfgService staticResCfgService;

//    private ResourceFileURLService() {
//    }

    @PostConstruct
    public void init() {
        Preconditions.checkArgument(staticResCfgService != null, "staticResCfgService can not be null");
        cssResCfgMap = staticResCfgService.getCssResCfgMap();
        jsResCfgMap = staticResCfgService.getJsResCfgMap();
        cssResCommMap = staticResCfgService.getCssResCommMap();
        jsResCommMap = staticResCfgService.getJsResCommMap();
    }


    /**
     * 取得css的真实URL
     *
     * @param cssUrl
     * @param altDomainKey
     * @param plat
     * @return
     */
    public static String getCssUrl(String cssUrl, String altDomainKey, String plat) {
        Map<String, String> cssResMap;
        if ("commons".equals(plat)) {
            cssResMap = cssResCommMap;
        } else {
            cssResMap = cssResCfgMap;
        }
        String altDomain = getFromKeptMap(altDomainKey, cssResMap);
        String[] strings = getUrl(cssUrl, CSS_URL_PATTERN, cssResMap, CSS_DEFAULT_DOMAIN, altDomain);
        if (strings != null && strings.length >= 2 && strings[1] != null) {
            String path = strings[1];
            // 测试服务器,不加md5码
            if (!"test.gmob.cn".equals(strings[0])) {
                path = getHashFilePath(cssResMap, path);
            }
            return "http://" + strings[0] + "/" + path;
        } else {
            return cssUrl;
        }
    }

    /**
     * 取得css的真实URL
     *
     * @param jpgUrl
     * @param altDomainKey
     * @param plat
     * @return
     */
    public  String getJpgUrl(String jpgUrl, String altDomainKey, String plat) {
        Map<String, String> cssResMap;
        if ("commons".equals(plat)) {
            cssResMap = cssResCommMap;
        } else {
            cssResMap = cssResCfgMap;
        }
        String altDomain = getFromKeptMap(altDomainKey, cssResMap);
        String[] strings = getUrl(jpgUrl, JPG_URL_PATTERN, cssResMap, JPG_DEFAULT_DOMAIN, altDomain);
        if (strings != null && strings.length >= 2 && strings[1] != null) {
            String path = strings[1];
            //builder.oliv.cn是测试服务器,不加md5码
            if (!"builder.oliv.cn".equals(strings[0])) {
                path = getHashFilePath(cssResMap, path);
            }
            return "http://" + strings[0] + "/" + path;
        } else {
            return jpgUrl;
        }
    }


    /**
     * @param jsUrl
     * @param plat
     * @param request
     * @return
     */
    public  String getJsUrl(final String jsUrl, final HttpServletRequest request, final String plat) {
        return getJsUrl(jsUrl, request, null, plat);
    }

    /**
     * 取得真实的JS的URL
     *
     * @param jsUrl
     * @param plat
     * @param request
     * @param projectPrefix
     * @return
     */
    public  String getJsUrl(final String jsUrl, final HttpServletRequest request, String projectPrefix, final String plat) {
        Cookie[] cookies = request != null ? request.getCookies() : null;
        boolean srcMode = false;
        Map<String, String> jsResMap;
        if ("commons".equals(plat)) {
            jsResMap = jsResCommMap;
        } else {
            jsResMap = jsResCfgMap;
        }
        /*
        * 1. 先根据ZooKeeper中的配置检查是否是源代码模式
        * 2. 再根据Cookie判断是否是源代码模式
        */
        do {
            if ("y".equals(getFromKeptMap("src_mode", jsResMap))) {
                srcMode = true;
            }
            //如果cookie里存在配置。则覆盖zooKeeper中的配置
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if ("sm".equals(cookie.getName())) {
                        if ("1".equals(cookie.getValue())) {
                            srcMode = true;
                            break;
                        } else if ("0".equals(cookie.getValue())) {
                            srcMode = false;
                            break;
                        }
                    }
                }
            }
        } while (false);

        //对外发布的url路径前缀
        String[] strings = getUrl(jsUrl, JS_URL_PATTERN, jsResMap, JS_DEFAULT_DOMAIN, null);
        if (strings != null && strings.length >= 2 && strings[1] != null) {
            return genJsUrl(projectPrefix, srcMode, strings, jsResMap);
        } else {
            return jsUrl;
        }
    }

    /**
     * 生成js路径
     *
     * @param projectPrefix
     * @param srcMode
     * @param strings
     * @return
     */
    private static String genJsUrl(String projectPrefix, boolean srcMode, String[] strings, Map<String, String> resMap) {
        String path = strings[1];
        String srcPrefixSlash = J_SRC_PREFIX + "/";
        String publishPrefixSlash = J_PREFIX + "/";
        if (path.startsWith(srcPrefixSlash)) {
            path = path.substring(srcPrefixSlash.length());
        } else if (path.startsWith(publishPrefixSlash)) {
            path = path.substring(publishPrefixSlash.length());
        }
        //源码模式不需要给文件加入MD5
        if (!srcMode) {
            //在非源代码模式下,加入项目的前缀
            if (projectPrefix != null) {
                path = getHashFilePath(resMap, projectPrefix + "/" + path);
            } else {
                path = getHashFilePath(resMap, path);
            }
        }
        String prefix = srcMode ? J_SRC_PREFIX : J_PREFIX;
        return "http://" + strings[0] + "/" + prefix + "/" + path;
    }

    /**
     * @param resMap
     * @param path
     * @return
     */
    private static String getHashFilePath(Map<String, String> resMap, String path) {
        String key = path.replaceAll("/", "!");
        String ret = getFromKeptMap(key, resMap);
        return ret == null ? path : ret;
    }

    /**
     * @param url
     * @param pattern
     * @param resMap
     * @param defaultDomain
     * @param altDomain
     * @return
     */
    private static String[] getUrl(final String url, final Pattern pattern, final Map<String, String> resMap, final String defaultDomain, final String altDomain) {
        if (url == null || url.isEmpty()) {
            return new String[]{};
        }
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            String domain = matcher.group(1);
            String path = matcher.group(2);
            String suffix = matcher.group(3);
            {
                /*
                 *  altDomain,configDomain
                 */
                if (altDomain != null) {
                    domain = altDomain;
                } else {
                    //从ZooKeeper中取得domain的配置
                    String configDomain = getFromKeptMap("domain", resMap);
                    if (configDomain != null) {
                        domain = configDomain;
                    } else {
                        domain = defaultDomain;
                    }
                }
            }
            String resPrefix = getFromKeptMap("prefix", resMap);
            return new String[]{domain + "/" + resPrefix, path + "." + suffix};
        } else {
            return new String[]{};
        }
    }

    private static String getFromKeptMap(String key, Map<String, String> map) {
        if (key == null) {
            return null;
        }
        return map != null ? map.get(key) : null;
    }

}
