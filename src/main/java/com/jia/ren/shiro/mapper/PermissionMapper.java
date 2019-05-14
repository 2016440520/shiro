package com.jia.ren.shiro.mapper;

import com.jia.ren.shiro.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission> getPermissionByUserName(String userName);
}
