package com.gedia.sms.studentmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author jiwenquan
 * @create 2018/7/2 13:58
 */
public class PermissionDTO implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 路径
     */
    private String url;
    /**
     * 权限编号
     */
    private String permissionCode;
    /**
     * 是否由shiro控制 --待定
     */
    private String isShiroCtrl;
    /**
     * 账号是否无限制 --待定
     */
    private String isAccessUnlimit;

    private Date created;
    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getIsShiroCtrl() {
        return isShiroCtrl;
    }

    public void setIsShiroCtrl(String isShiroCtrl) {
        this.isShiroCtrl = isShiroCtrl;
    }

    public String getIsAccessUnlimit() {
        return isAccessUnlimit;
    }

    public void setIsAccessUnlimit(String isAccessUnlimit) {
        this.isAccessUnlimit = isAccessUnlimit;
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
