package com.jia.ren.shiro.service;

import com.jia.ren.shiro.pojo.Role;
import com.jia.ren.shiro.pojo.User;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByUserName(String userName);

}
