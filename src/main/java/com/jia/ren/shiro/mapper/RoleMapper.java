package com.jia.ren.shiro.mapper;

import com.jia.ren.shiro.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRolesByUserName(String userName);
}
