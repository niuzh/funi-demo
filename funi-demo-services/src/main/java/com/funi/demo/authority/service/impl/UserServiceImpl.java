package com.funi.demo.authority.service.impl;

import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @author zhihuan.niu on 2016/11/1.
 */
@Component
public class UserServiceImpl implements IUserService {
    /**
     * 新增用户
     *
     * @param record      新增记录
     * @param currentUser 当前操作人员
     */
    @Override
    public void createRecord(User record, User currentUser) {

    }
}
