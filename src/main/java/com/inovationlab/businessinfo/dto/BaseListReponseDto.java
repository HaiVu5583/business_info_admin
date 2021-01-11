package com.inovationlab.businessinfo.dto;

import java.util.List;

public class BaseListReponseDto<T> {
    private int page;
    private int totalPage;
    private List<T> list;

    public BaseListReponseDto() {
    }

    public BaseListReponseDto(int page, int totalPage, List<T> list) {
        this.page = page;
        this.totalPage = totalPage;
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
