package com.funi.demo.utils;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhihuan.niu on 2016/11/3.
 */
public class ReflectUtilTest {
    @Test
    public void test()throws Exception{
        Date date=new DateUtils().getStartDate(new Date());
        System.out.println(date);
        //通过类装载器获得对象
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        //类装载器寻找类的字节码文件并装入JVM ClassLoader ExtClassLoader AppClassLoader 全盘负责委托机制
        System.out.println("currentLoader:"+loader);
        System.out.println("currentLoader getParent:"+loader.getParent());
        System.out.println("currentLoader getParent getParent:"+loader.getParent().getParent());
        //clazz 反射对象描述类语义结构
        Class clazz=loader.loadClass("com.funi.demo.utils.DateUtils");
        //获得对象的构造器并实例化
        Constructor cons=clazz.getDeclaredConstructor((Class[]) null);
        DateUtils util=(DateUtils)cons.newInstance();
        //通过反射调用方法
        Method method=clazz.getMethod("getStartDate",Date.class);
        Date startDate=(Date)method.invoke(util,new Date());
        System.out.println(startDate);
    }
}
