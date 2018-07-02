package com.gedia.sms.studentmanagementsystem.entity;

import java.util.Date;

/**
 * 班级
 *
 * @author jiwenquan
 * @create 2018/6/28 13:41
 */
public class Class {
    /**
     * 主键id
     */
    private String id;
    /**
     * 班级编号
     */
    private String classNum;
    /**
     * 备注
     */
    private String remark;
    private Date created;
    private Date updated;
    private String createUser;
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
