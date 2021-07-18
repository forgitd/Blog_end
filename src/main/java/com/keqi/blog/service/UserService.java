package com.keqi.blog.service;

import com.keqi.blog.pojo.User;

public interface UserService {
    User getUser(String name, String pwd);
    User checkById(int id);
}
