package org.blumea.cms.web.taglib.tag;

import com.google.common.base.Strings;
import net.common.utils.html.HtmlUtils;
import net.common.utils.html.JavaScriptUtils;
import org.owasp.esapi.ESAPI;

/**
 * 在JSP上常用的工具方法
 */
public final class Functions {


    private Functions() {
    }

    /**
     * 将js的内容转义,防止XSS攻击
     *
     * @param js 向页面中输出的JavaScript内容
     * @return
     */
    public static String escapeJS(String js) {
        if (Strings.isNullOrEmpty(js)) {
            return js;
        }
        return JavaScriptUtils.javaScriptEscape(js);
    }

    /**
     * 将html内容转义,防止XSS攻击
     *
     * @param html 向页面中输出的HTML内容
     * @return
     */
    public static String escapeHTML(String html) {
        if (Strings.isNullOrEmpty(html)) {
            return html;
        }
        return HtmlUtils.htmlEscape(html);
    }

    /**
     * 将css内容转义,防止XSS攻击
     *
     * @param css 向页面中输出的CSS内容
     * @return
     */
    public static String escapeCSS(String css) {
        if (Strings.isNullOrEmpty(css)) {
            return css;
        }
        return ESAPI.encoder().encodeForCSS(css);
    }
}
