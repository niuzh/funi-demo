package com.funi.demo.web.supports;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2017/4/26.
 */
public class PagingList<E>{
    private Long total;
    private List<E> list;
    public PagingList() {
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}