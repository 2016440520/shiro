package com.jia.ren.shiro.pojo;

import java.util.List;

public class Permission {
    private Integer id; // 编号

    private String permissionName; // 菜单名称

    private String remarks; // 备注

    private String parent;

    private List<Permission> childPermissions;

    private String msg;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Permission(Integer id, String permissionName, String remarks) {
        this.id = id;
        this.permissionName = permissionName;
        this.remarks = remarks;
    }


    public Permission() {
    }

    public Permission(String permissionName, String remarks, String parent, List<Permission> childPermissions, String msg) {
        this.permissionName = permissionName;
        this.remarks = remarks;
        this.parent = parent;
        this.childPermissions = childPermissions;
        this.msg = msg;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<Permission> getChildPermissions() {
        return childPermissions;
    }

    public void setChildPermissions(List<Permission> childPermissions) {
        this.childPermissions = childPermissions;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
