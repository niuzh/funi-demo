package com.funi.demo.web.supports;

public class RestListResult<T> extends RestResult<T>{
    private long total;
    public RestListResult(T result,long total) {
        super(result);
        this.total=total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}