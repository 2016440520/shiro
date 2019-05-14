package com.jia.ren.shiro.service.impl;

import com.jia.ren.shiro.mapper.PermissionMapper;
import com.jia.ren.shiro.pojo.Permission;
import com.jia.ren.shiro.pojo.Role;
import com.jia.ren.shiro.pojo.User;
import com.jia.ren.shiro.service.PermissionService;
import com.jia.ren.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImple implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Permission> getPermissionByUserName(String userName) {
        List<Permission>  permissions = permissionMapper.getPermissionByUserName(userName);
        return permissions;
    }




}
