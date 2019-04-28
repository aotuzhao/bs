package com.magpie.bbs.forum.model;

import org.beetl.sql.core.TailBean;

import java.io.Serializable;

/**
 * @Title: BasePage
 * @Description: 分页
 * @Date: 2019/4/25 10:42
 * @Auther: zhaoxuezhao
 */
public class BasePage extends TailBean implements Serializable {
     Integer currentPage;
     Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
