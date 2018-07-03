package com.gedia.sms.studentmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色
 *
 * @author jiwenquan
 * @create 2018/7/2 15:44
 */
public class UserRoleDTO implements Serializable {

    /**
     * 主键id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    //角色编号
    private String roleCode;
    private Date created;
    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
}
