package com.jia.ren.shiro.pojo;

public class RolePermission {


	private Integer id; // 编号

	private Role role; // 角色

	private Permission menu; // 菜单

	private String remarks; // 备注
	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getMenu() {
		return menu;
	}

	public void setMenu(Permission menu) {
		this.menu = menu;
	}

	public RolePermission(Integer id, Role role, Permission menu, String remarks) {
		this.id = id;
		this.role = role;
		this.menu = menu;
		this.remarks = remarks;
	}

	public RolePermission() {
	}
}
