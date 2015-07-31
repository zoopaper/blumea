package org.blumea.cms.web.taglib.tag;

import org.blumea.cms.web.taglib.ResourceType;
import org.blumea.cms.web.taglib.model.LoadPoint;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 14:29
 */
public abstract class BaseResourceFragTag extends BodyTagSupport {
    /**
     * 要被加载的资源的类型,如javascript,css等
     */
    private final ResourceType resourceType;

    /**
     * Tag的属性:资源的加载点
     *
     */
    private String point;

    /**
     * Tag的属性:外链资源的地址
     */
    private String src;

    /**
     * 使用静态资源区分(公共资源，个体资源)
     */
    private String plat;

    public BaseResourceFragTag(ResourceType resourceType) {
        this.resourceType = resourceType;
        this.init();
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    @Override
    public int doStartTag() throws JspException {
        this.renderHtmlBeginTag();
        if (this.getSrc() != null) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_INCLUDE;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        this.renderHtmlEndTag();
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
        this.init();
    }

    /**
     * 初始化资源
     */
    private void init() {
        this.point = LoadPoint.BEFORE_LOAD.getType();
        this.src = null;
    }

    /**
     * 渲染HTML格式的数据时,要求出现的html开始标签
     */
    protected abstract void renderHtmlBeginTag() throws JspException;

    /**
     * 渲染HTML格式的数据时,要求出现的html结束标签
     */
    protected abstract void renderHtmlEndTag() throws JspException;

    /**
     * 取得资源的真实地址
     *
     * @param src
     * @return
     */
    protected abstract String getRealSrc(String src);
}
