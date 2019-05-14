package com.jia.ren.shiro.service.impl;

import com.jia.ren.shiro.mapper.UserMapper;
import com.jia.ren.shiro.pojo.User;
import com.jia.ren.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String userName) {
        User user = userMapper.findUserByName(userName);
        System.out.println(userName);
        System.out.println(user);
        return user;
    }


}
