package com.funi.demo.authority.domain;

import java.io.Serializable;

/**
 * �������-ʵ����
 * @author zhihuan.niu on 2016/11/1.
 */
public class User implements Serializable{
    //id
    private String id;
    //�û���
    private String userName;
    //�û�����
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
