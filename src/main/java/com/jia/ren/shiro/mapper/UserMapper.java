package com.jia.ren.shiro.mapper;

import com.jia.ren.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

     User findUserByName(String userName);

}
