package com.funi.demo.web.controller;

import com.funi.demo.authority.domain.User;

/**
 * @author zhihuan.niu on 2016/11/2.
 */
public class BaseController {
    /**
     * ���ص�ǰ��¼�û�
     * @return
     */
    protected User getCurrentUser(){
        User user=new User();
        user.setUserName("user");
        user.setId("user");
        return user;
    }
}
