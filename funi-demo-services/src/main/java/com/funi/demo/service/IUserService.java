package com.funi.demo.service;

import com.funi.demo.mbg.dto.User;
import com.funi.demo.query.UserQuery;
import com.funi.demo.supports.PageableQuery;

import java.util.List;

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

    /**
     * 返回用户
     * @return
     */
    List<User> findUserList(UserQuery query);
}
