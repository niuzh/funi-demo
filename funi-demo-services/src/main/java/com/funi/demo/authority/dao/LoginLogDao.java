package com.funi.demo.authority.dao;

import com.funi.demo.authority.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author zhihuan.niu
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入日志对象
     * @param loginLog
     */
    public void insertLoginLog(LoginLog loginLog){
        String sqlStr="insert into t_login_log(user_id,ip,login_datetime) "
                +" values(?,?,?)";
        Object[] args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr,args);
    }
}
