package com.funi.demo.authority.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 领域对象(实体类)-同时被持久层、业务层和展现层共享使用，最终持久化到数据库中
 * 用户信息
 * @author zhihuan.niu
 */
public class User implements Serializable{
    //id
    private Integer userId;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //积分
    private Integer credits;
    private String lastIp;
    private Date lastVisit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
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
