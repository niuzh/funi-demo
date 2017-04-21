package com.funi.demo.web.supports;

import com.funi.demo.mbg.dto.User;

/**
 * controller基类
 * @author zhihuan.niu
 */
public abstract class BaseController {
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
