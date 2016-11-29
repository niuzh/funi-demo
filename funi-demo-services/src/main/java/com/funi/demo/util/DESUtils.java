package com.funi.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES对称加密解密工具
 * @author zhihuan.niu
 */
public class DESUtils {
    //指定DES加密解密的密钥
    private static Key key;
    private static String KEY_STR="mykey";
    static {
        try {
            KeyGenerator generator=KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key=generator.generateKey();
            generator=null;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密并返回字符串
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        try {
            byte[] bytes=str.getBytes("UTF8");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes=cipher.doFinal(bytes);
            return base64Encoder.encode(encryptStrBytes);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    /**
     * 解密并返回字符串
     * @param str
     * @return
     */
    public static String getDecryptString(String str){
        BASE64Decoder base64Decoder=new BASE64Decoder();
        try {
            byte[] base64De=base64Decoder.decodeBuffer(str);
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] decryptBytes=cipher.doFinal(base64De);
            return new String(decryptBytes,"UTF8");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
