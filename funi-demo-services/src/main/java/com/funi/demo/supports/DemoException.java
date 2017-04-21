package com.funi.demo.supports;

/**
 * 异常类
 * @author zhihuan.niu on 2017/4/21.
 */
public class DemoException extends IllegalStateException {
    public DemoException(){}
    public DemoException(String s){
        super(s);
    }

    public DemoException(String s,Throwable throwable){
        super(s,throwable);
    }

    public DemoException(Throwable throwable){
        super(throwable);
    }
}
