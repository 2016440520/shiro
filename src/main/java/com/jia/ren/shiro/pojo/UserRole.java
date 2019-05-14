package com.jia.ren.shiro.pojo;

public class UserRole {
    private Integer id;
    private String remarks;
    private Integer RoleId;
    private Integer UserId;

    public UserRole(Integer id, String remarks, Integer roleId, Integer userId) {
        this.id = id;
        this.remarks = remarks;
        RoleId = roleId;
        UserId = userId;
    }

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }
}
