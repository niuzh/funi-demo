package com.funi.demo.authority.service;

import com.funi.demo.authority.domain.User;

/**
 * @author zhihuan.niu
 */
public interface IUserService {
    /**
     * 检查用户名密码
     * @param userName
     * @param password
     * @return
     */
    boolean hasMatchUser(String userName,String password);

    /**
     * 根据用户名加载用户
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 更新用户登录信息
     * @param user
     */
    void loginSuccess(User user);
}
