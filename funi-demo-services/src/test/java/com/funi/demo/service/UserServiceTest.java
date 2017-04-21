package com.funi.demo.service;

import com.funi.demo.BaseTest;
import com.funi.demo.mbg.dto.User;
import com.funi.demo.query.UserQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 单元测试类包和程序的类包对应
 * @author zhihuan.niu
 */
public class UserServiceTest extends BaseTest{
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
        assertEquals(user.getName(), "admin");
    }
    @Test
    public void findUserListPage(){
        UserQuery query=new UserQuery();
        query.setPageNum(2);
        query.setPageSize(5);
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<User> list=userService.findUserList(query);
        PageInfo page = new PageInfo(list);
        logger.info(page.getTotal()+"");
    }
}
