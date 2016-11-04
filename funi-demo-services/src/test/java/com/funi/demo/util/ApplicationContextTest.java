package com.funi.demo.util;

import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import com.funi.demo.authority.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author zhihuan.niu on 2016/11/3.
 */
public class ApplicationContextTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("config.spring/spring-source.xml");
        IUserService userService=context.getBean(UserServiceImpl.class);
        User user=userService.findUserByUserName("admin");
        assertEquals(user.getUserName(),"admin");
    }
}
