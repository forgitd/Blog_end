package com.keqi.blog.service.impl;

import com.keqi.blog.mapper.UserMapper;
import com.keqi.blog.pojo.User;
import com.keqi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User getUser(String name, String pwd) {
        return userMapper.getUser(name, pwd);
    }

    @Override
    public User checkById(int id) {
        return userMapper.checkById(id);
    }
}
