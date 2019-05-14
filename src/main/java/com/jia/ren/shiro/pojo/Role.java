package com.jia.ren.shiro.pojo;


public class Role {

	private Integer id; // 编号

	private String roleName; // 角色名称

	private String remarks; // 备注
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Role(Integer id, String roleName, String remarks) {
		this.id = id;
		this.roleName = roleName;
		this.remarks = remarks;
	}

	public Role() {
	}
}
