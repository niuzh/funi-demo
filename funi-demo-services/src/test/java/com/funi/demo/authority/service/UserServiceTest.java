package com.funi.demo.authority.service;

import com.funi.demo.authority.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 单元测试类包和程序的类包对应
 * @author zhihuan.niu
 */
@RunWith(SpringJUnit4ClassRunner.class)//指定测试运行器
@ContextConfiguration({//指定Spring配置文件
        "classpath*:config.spring/spring-*.xml",//数据源配置
})
public class UserServiceTest {
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
    @Autowired
    private IUserService userService;
    @Test//标注为测试方法
    public void hasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","1111");
        assertTrue(b1);
        //assertTrue(b2);
    }
    @Test
    public void findUserByUserName(){
        User user=userService.findUserByUserName("admin");
        assertEquals(user.getUserName(),"admin");
    }
}
