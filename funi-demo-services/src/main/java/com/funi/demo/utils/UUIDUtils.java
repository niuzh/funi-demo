package com.funi.demo.utils;

import java.util.UUID;

/**
 * UUID工具类
 * @author zhihuan.niu on 2017/4/21.
 */
public class UUIDUtils {
    public UUIDUtils() {
    }

    /**
     * 产生原始UUID字符串
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 产生不带空格UUID字符串
     * @return
     */
    public static String getUUIDNotSpace() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
