package com.funi.demo.authority.dao;

import com.funi.demo.authority.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �־ò㸺�����ݵķ��ʺͲ�������ҵ������
 * @author zhihuan.niu
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * �����û����������ȡƥ����û���
     */
    public int getMatchCount(String userName,String password){
        String sqlStr="select count(1) from t_user "
                +" where user_name=? and password=?";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
    }

    /**
     * �����û�����ȡuser����
     */
    public User findUserByUserName(final String userName){
        String sqlStr="select user_id,user_name,credits "
                +" from t_user where user_name=?";
        final User user=new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {//�����ڲ���
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    /**
     * �����û���¼��Ϣ
     */
    public void updateLoginInfo(User user){
        String sqlStr="update t_user set last_visit=?,last_ip=?,credit=? "
                +" where user_id=?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLstVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
