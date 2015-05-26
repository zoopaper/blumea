package org.stream.web.taglib.model;

/**
 * 资源的加载点的类型
 * <p/>
 * User : dongyong.wang@mail-inc.com
 * Date: 12-05-09
 * Time: 下午2:15
 */
public enum LoadPoint {

    /**
     * 视图显示前需要加载和执行的脚本和样式
     */
    BEFORE_LOAD("before"),

    /**
     * 视图显示后需要加载和执行的脚本和样式
     */
    AFTER_LOAD("after");

    private final String type;

    LoadPoint(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * 根据{@link #getType()}的取的LoadPoint
     *
     * @param type
     * @return
     * @throws RuntimeException 如果没有对应的名称,则会抛出异常
     */
    public static LoadPoint getByType(final String type) {
        if (BEFORE_LOAD.getType().equals(type)) {
            return BEFORE_LOAD;
        } else if (AFTER_LOAD.getType().equals(type)) {
            return AFTER_LOAD;
        } else {
            throw new RuntimeException("Unknown load point type [" + type + "]");
        }
    }

}
