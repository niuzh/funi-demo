package com.funi.demo.authority.domain;

import java.io.Serializable;

/**
 * 领域对象-实体类
 * @author zhihuan.niu on 2016/11/1.
 */
public class User implements Serializable{
    //id
    private String id;
    //用户名
    private String userName;
    //用户密码
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
