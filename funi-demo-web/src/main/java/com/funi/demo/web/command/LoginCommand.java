package com.funi.demo.web.command;

/**
 * command 对象用于收集前端的参数
 * @author zhihuan.niu
 */
public class LoginCommand {
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
