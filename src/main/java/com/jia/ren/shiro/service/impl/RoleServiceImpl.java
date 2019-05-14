package com.jia.ren.shiro.service.impl;

import com.jia.ren.shiro.mapper.RoleMapper;
import com.jia.ren.shiro.pojo.Role;
import com.jia.ren.shiro.pojo.User;
import com.jia.ren.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRolesByUserName(String userName) {
        List<Role>  roles = roleMapper.getRolesByUserName(userName);
        return roles;
    }


}
