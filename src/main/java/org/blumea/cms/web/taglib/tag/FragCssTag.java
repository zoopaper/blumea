package org.blumea.cms.web.taglib.tag;

import org.blumea.cms.web.taglib.ResourceFileURLUtil;
import org.blumea.cms.web.taglib.ResourceType;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/26
 * Time: 14:28
 */
public class FragCssTag extends BaseResourceFragTag {

    private static final long serialVersionUID = -4364245066296737094L;
    /**
     * 优先转换的域名key
     */
    private String altDomain;

    /**
     * id
     */
    private String id;

    public FragCssTag() {
        super(ResourceType.CSS);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAltDomain() {
        return altDomain;
    }

    public void setAltDomain(String altDomain) {
        this.altDomain = altDomain;
    }

    @Override
    protected void renderHtmlBeginTag() throws JspException {
        final JspWriter out = this.pageContext.getOut();
        if (this.getSrc() != null) {
            // 显示外链的css标签
            String src = this.getRealSrc(this.getSrc());
            if (src == null) {
                src = this.getSrc();
            }
            final String link = "<link " + ((id != null && !"".equals(id)) ? "id='" + id + "'" : "") + " href='" + src + "' type='text/css' rel='stylesheet'>";
            try {
                out.write(link);
            } catch (IOException e) {
                throw new JspException(e);
            }
        } else {
            // 显示内联标签
            try {
                out.write("<style type='text/css'>");
            } catch (IOException e) {
                throw new JspException(e);
            }
        }
    }

    @Override
    public void release() {
        super.release();
        this.altDomain = null;
    }

    @Override
    protected void renderHtmlEndTag() throws JspException {
        if (this.getSrc() != null) {
            return;
        }
        final JspWriter out = this.pageContext.getOut();
        try {
            out.write("</style>");
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    @Override
    protected String getRealSrc(final String src) {
        // 当前简单处理：直接替换掉域名
        String realSrc = ResourceFileURLUtil.getCssUrl(this.getSrc(), this.getAltDomain(), this.getPlat());
        if (realSrc == null) {
            realSrc = src;
        }
        return realSrc;
    }

}
