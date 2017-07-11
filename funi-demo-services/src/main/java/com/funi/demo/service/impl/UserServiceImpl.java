package com.funi.demo.service.impl;

import com.funi.demo.mbg.dao.UserMapper;
import com.funi.demo.mbg.dto.User;
import com.funi.demo.mbg.dto.UserExample;
import com.funi.demo.query.UserQuery;
import com.funi.demo.service.IUserService;
import com.funi.demo.supports.PageableQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 业务类 通过配置享受声明式事务的好处
 * @author zhihuan.niu
 */
@Service
public class UserServiceImpl implements IUserService,ApplicationContextAware{
    @Autowired
    private UserMapper userMapper;
    private ApplicationContext applicationContext;
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
        UserExample example=new UserExample();
        UserExample.Criteria criteria =example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        long matchCount = userMapper.countByExample(example);
        if (matchCount > 0) {
            return true;
        }
        throw new RuntimeException(applicationContext.getMessage("user_err", null, Locale.SIMPLIFIED_CHINESE));
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
        UserExample example=new UserExample();
        UserExample.Criteria criteria =example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> userList= userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            throw new RuntimeException(applicationContext.getMessage("user_not",new String[]{userName}, Locale.SIMPLIFIED_CHINESE));
        }
        return userList.get(0);
    }

    /**
     * 更新用户登录信息
     *
     * @param user
     */
    @Override
    public void loginSuccess(User user) {
        user.setLastLoginDate(new Date());
        user.setSysUpdateTime(new Date());
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> findUserList(UserQuery query) {

        List<User> list= userMapper.selectByExample(new UserExample());
        return list;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
