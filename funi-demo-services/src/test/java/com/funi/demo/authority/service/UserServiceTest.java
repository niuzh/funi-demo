package com.funi.demo.authority.service;

import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhihuan.niu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath*:/config/spring/spring-source.xml",//数据源配置
        //"classpath:config/spring/orm-core.xml",//orm 核心配置
        //"classpath:/mock-beans.xml", //框架mock驱动
})
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void createRecord(){
        User user=new User();
        userService.createRecord(user,user);
    }
}
