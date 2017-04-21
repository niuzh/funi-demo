package com.funi.demo.web.supports;

public class RestResult<T> {
    private final boolean success;
    private final T result;

    public RestResult(T result) {
        this.success = true;
        this.result = result;
    }

    public RestResult(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }
}