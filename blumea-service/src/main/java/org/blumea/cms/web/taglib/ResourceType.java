package org.blumea.cms.web.taglib;

/**
 * 定义用于加载的资源的类型
 */
public enum ResourceType {

    /**
     * java script
     */
    JAVA_SCRIPT("javascript"),
    /**
     * css
     */
    CSS("css");

    /**
     * 资源类型的名称
     */
    private final String name;

    ResourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
