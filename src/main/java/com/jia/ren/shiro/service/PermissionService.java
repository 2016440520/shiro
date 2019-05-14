package com.jia.ren.shiro.service;

import com.jia.ren.shiro.pojo.Permission;
import com.jia.ren.shiro.pojo.User;

import java.util.List;

public interface PermissionService {

    List<Permission> getPermissionByUserName(String userName);

}
