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
     * �����û�
     *
     * @param record      ������¼
     * @param currentUser ��ǰ������Ա
     */
    @Override
    public void createRecord(User record, User currentUser) {

    }
}
