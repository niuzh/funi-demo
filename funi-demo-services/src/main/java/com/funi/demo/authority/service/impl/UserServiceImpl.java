package com.funi.demo.authority.service.impl;

import com.funi.demo.authority.dao.UserDao;
import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhihuan.niu on 2016/11/1.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    /**
     * �����û�
     *
     * @param record      ������¼
     * @param currentUser ��ǰ������Ա
     */
    @Override
    public void createRecord(User record, User currentUser) {
        userDao.insertRecord(record);
    }
}
