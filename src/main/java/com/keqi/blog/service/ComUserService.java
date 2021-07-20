package com.keqi.blog.service;

import com.keqi.blog.pojo.CommonUser;

public interface ComUserService {
    boolean addComUser(String name, String pwd);
    CommonUser getComUserByN_P(String name, String pwd);
}
