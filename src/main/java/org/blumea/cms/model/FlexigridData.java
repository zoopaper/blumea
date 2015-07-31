package org.blumea.cms.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * flexigrid返回结果封装
 */
public class FlexigridData<T> {

    /**
     * 总记录条数
     */
    private int total = 0;

    /**
     * 当前页
     */
    private int page = 1;

    /**
     * 结果集
     */
    private List<T> rows = Lists.newArrayList();

    public FlexigridData() {
    }

    public FlexigridData(int total, int page) {
        this.total = total;
        this.page = page;
    }

    public FlexigridData(int total, int page, List<T> rows) {
        this.total = total;
        this.page = page;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return String.format("[total: %s, page: %s, rows.size: %s]", total, page, (rows == null ? "null" : rows.size()));
    }
}
