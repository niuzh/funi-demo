package com.funi.demo.supports;

import java.util.Date;

/**
 * dto基类
 * @author zhihuan.niu
 */
public class BasicDto {
    /**
     * 是否逻辑删除
     */
    private Integer isDeleted=new Integer(0);

    /**
     * 版本号
     */
    private Integer version=new Integer(0);;

    /**
     * 创建时间
     */
    private Date sysCreateTime=new Date();

    /**
     * 更新时间
     */
    private Date sysUpdateTime=new Date();

    /**
     * 删除时间
     */
    private Date sysDeleteTime=new Date();

    /**
     * 创建者
     */
    private String sysCreateId;

    /**
     * 最后更新人
     */
    private String sysUpdateId;

    /**
     * 删除人
     */
    private String sysDeleteId;

    /**
     * 得到是否逻辑删除
     * @return  是否逻辑删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否逻辑删除
     * @param isDeleted 是否逻辑删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 得到版本号
     * @return  版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 得到创建时间
     * @return  创建时间
     */
    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    /**
     * 设置创建时间
     * @param sysCreateTime 创建时间
     */
    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    /**
     * 得到更新时间
     * @return  更新时间
     */
    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    /**
     * 设置更新时间
     * @param sysUpdateTime 更新时间
     */
    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    /**
     * 得到删除时间
     * @return  删除时间
     */
    public Date getSysDeleteTime() {
        return sysDeleteTime;
    }

    /**
     * 设置删除时间
     * @param sysDeleteTime 删除时间
     */
    public void setSysDeleteTime(Date sysDeleteTime) {
        this.sysDeleteTime = sysDeleteTime;
    }

    /**
     * 得到创建者
     * @return  创建者
     */
    public String getSysCreateId() {
        return sysCreateId;
    }

    /**
     * 设置创建者
     * @param sysCreateId 创建者
     */
    public void setSysCreateId(String sysCreateId) {
        this.sysCreateId = sysCreateId == null ? null : sysCreateId.trim();
    }

    /**
     * 得到最后更新人
     * @return  最后更新人
     */
    public String getSysUpdateId() {
        return sysUpdateId;
    }

    /**
     * 设置最后更新人
     * @param sysUpdateId 最后更新人
     */
    public void setSysUpdateId(String sysUpdateId) {
        this.sysUpdateId = sysUpdateId == null ? null : sysUpdateId.trim();
    }

    /**
     * 得到删除人
     * @return  删除人
     */
    public String getSysDeleteId() {
        return sysDeleteId;
    }

    /**
     * 设置删除人
     * @param sysDeleteId 删除人
     */
    public void setSysDeleteId(String sysDeleteId) {
        this.sysDeleteId = sysDeleteId == null ? null : sysDeleteId.trim();
    }
}
