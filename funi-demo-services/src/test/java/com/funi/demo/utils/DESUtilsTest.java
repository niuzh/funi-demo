package com.funi.demo.utils;

import org.junit.Test;

/**
 * @author zhihuan.niu
 */
public class DESUtilsTest {
    @Test
    public void test(){
        String str="niu";
        String encryptString=DESUtils.getEncryptString(str);
        System.out.println(encryptString);
        String deStr= DESUtils.getDecryptString(encryptString);
        System.out.println(deStr);
    }
}
