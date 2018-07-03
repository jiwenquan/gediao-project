package com.gedia.sms.studentmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限
 *
 * @author jiwenquan
 * @create 2018/7/2 16:20
 */
public class RolePermissionDTO implements Serializable {

    /**
     * 主键id
     */
    private String id;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 权限id
     */
    private String permissionId;
    private Date created;
    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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
