package org.stream.model;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/5/29
 * Time: 19:59
 */
public class Page<T> {

    /**
     * 总记录条数
     */
    private int total;
    /**
     * 当前页码数
     */
    private int pageIndex;
    /**
     * 最大页码数
     */
    private int maxPage;
    /**
     * 每页记录条数
     */
    private int pageSize;
    private List<T> items;

    /**
     * @param pageIndex 页码
     * @param pageSize  每页大小
     */
    public Page(int pageIndex, int pageSize) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
    }

    /**
     * @param pageIndex 页码
     * @param pageSize  每页大小
     * @param total     总记录条数
     */
    public Page(int pageIndex, int pageSize, int total) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
        setTotal(total);
    }

    /**
     * 计算记录查询的起始位置
     *
     * @return 查询起始位置
     */
    public int getFromIndex() {
        return (getPageIndex() - 1) * pageSize;
    }

    public int getTotal() {
        return total;
    }

    public final void setTotal(int total) {
        if (pageSize <= 0) {
            this.total = total;
            maxPage = 1;
        } else {
            this.total = total;
            maxPage = ((total % pageSize) == 0 ? (total / pageSize) : (total
                    / pageSize + 1));
            if (0 == maxPage) {
                maxPage = 1;
            }
        }
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public final void setPageIndex(int pageIndex) {
        this.pageIndex = (pageIndex < 1) ? 1 : pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
