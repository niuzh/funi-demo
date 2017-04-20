package com.funi.demo.web.controller;

import com.funi.demo.mbg.dto.User;

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
        user.setName("user");
        user.setId("1");
        return user;
    }
}
