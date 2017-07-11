package com.funi.demo.mbg.dto;

import com.funi.demo.supports.BasicDto;
import java.io.Serializable;
import java.util.Date;

public class User extends BasicDto implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * serialVersionUID 序列号 
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.last_login_date
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private Date lastLoginDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.last_login_ip
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private String lastLoginIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.REMARK
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.last_login_date
     *
     * @return the value of t_user.last_login_date
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.last_login_date
     *
     * @param lastLoginDate the value for t_user.last_login_date
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.last_login_ip
     *
     * @return the value of t_user.last_login_ip
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.last_login_ip
     *
     * @param lastLoginIp the value for t_user.last_login_ip
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.REMARK
     *
     * @return the value of t_user.REMARK
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.REMARK
     *
     * @param remark the value for t_user.REMARK
     *
     * @mbg.generated Tue Jul 11 08:47:19 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	//自定义属性或方法
}