package com.funi.demo.authority.service.impl;

import com.funi.demo.authority.dao.LoginLogDao;
import com.funi.demo.authority.dao.UserDao;
import com.funi.demo.authority.domain.LoginLog;
import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务类 通过配置享受声明式事务的好处
 * @author zhihuan.niu
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 检查用户名密码
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
     * 根据用户名加载用户
     *
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        logger.debug("findUserByUserName debug");
        logger.info("findUserByUserName info");
        try {
            throw new NullPointerException("NullPointerException");
        }catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return userDao.findUserByUserName(userName);
    }

    /**
     * 更新用户登录信息
     *
     * @param user
     */
    @Override
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits()+5);
        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
