package com.funi.demo.authority.service;

import com.funi.demo.authority.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author zhihuan.niu on 2016/11/1.
 */
public interface IUserService {
    /**
     * 新增用户
     * @param record         新增记录
     * @param currentUser   当前操作人员
     */
    void createRecord(User record,User currentUser);
}
