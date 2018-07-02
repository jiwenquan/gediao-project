package com.gedia.sms.studentmanagementsystem.entity;

/**
 * 角色
 *
 * @author jiwenquan
 * @create 2018/6/28 17:55
 */
public class Role {
    /**
     * 主键id
     */
    private String id;
    /**
     * 角色
     */
    private String role;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 是否有效
     */
    private Boolean flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
