package com.funi.demo.web.controller;

import com.funi.demo.authority.domain.User;

/**
 * @author zhihuan.niu
 */
public class BaseController {
    /**
     * 返回当前登录用户
     * @return
     */
    protected User getCurrentUser(){
        User user=new User();
        user.setUserName("user");
        user.setUserId(1);
        return user;
    }
}
