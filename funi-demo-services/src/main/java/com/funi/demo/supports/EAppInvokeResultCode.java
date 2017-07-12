package com.funi.demo.supports;

/**
 * 远程调用枚举
 * @author zhihuan.niu on 7/12/17.
 */
public enum  EAppInvokeResultCode {
    OTHER("AP001"),
    NOT_EXISTS("AP002"),
    NOT_RUNNING("AP003"),
    INVALID_ARGUMENTS("AP004"),
    NOT_EXPORT("AP005"),
    NO_PROVIDERS_FOUND("AP006"),
    SUCCESS("AP000");

    private String code;

    public String getCode() {
        return this.code;
    }

    public String getDefaultMessage() {
        return this.name();
    }

    public void setCode(String code) {
        this.code = code;
    }

    private EAppInvokeResultCode(String code) {
        this.code = code;
    }
}
