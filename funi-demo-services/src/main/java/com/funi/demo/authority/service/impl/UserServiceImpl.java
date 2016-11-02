package com.funi.demo.authority.service.impl;

import com.funi.demo.authority.dao.LoginLogDao;
import com.funi.demo.authority.dao.UserDao;
import com.funi.demo.authority.domain.LoginLog;
import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ҵ���� ͨ��������������ʽ����ĺô�
 * @author zhihuan.niu
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * ����û�������
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean hasMatchUser(String userName, String password) {
        int matchCount=userDao.getMatchCount(userName,password);
        return matchCount>0;
    }

    /**
     * �����û��������û�
     *
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    /**
     * �����û���¼��Ϣ
     *
     * @param user
     */
    @Override
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits()+5);
        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLstVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
