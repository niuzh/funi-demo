package com.funi.demo.authority.dao;

import com.funi.demo.authority.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhihuan.niu on 2016/11/1.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询记录
     * @param id
     * @return
     */
    public User selectRecordById(final String id){
        String sql="select * from user where user_name=?";
        final User user=new User();
        jdbcTemplate.query(sql, new Object[]{id},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setId(id);
                        user.setUserName(resultSet.getString("user_name"));
                        user.setPassword(resultSet.getString("password"));
                    }
                });
        return user;
    }

    /**
     * 新增记录
     * @param record
     */
    public void insertRecord(User record){
        String sql="insert into t_user(id,user_name,password) values(?,?,?)";
        Object[] args={record.getId(),record.getUserName(),record.getPassword()};
        jdbcTemplate.update(sql,args);
    }
}
