package com.funi.demo.supports;

import java.io.Serializable;

/**
 * @author zhihuan.niu on 7/12/17.
 */
public class AppInvocationResult implements Serializable{
    private String message;
    private String code;
    private String data;

    public AppInvocationResult() {
        this.code = EAppInvokeResultCode.SUCCESS.getCode();
    }

    public static AppInvocationResult newError(String message, String code) {
        AppInvocationResult appInvocationResult = new AppInvocationResult();
        appInvocationResult.setCode(code);
        appInvocationResult.setMessage(message);
        return appInvocationResult;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return EAppInvokeResultCode.SUCCESS.getCode().equals(this.code);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
