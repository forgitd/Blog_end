package com.keqi.blog.service.impl;

import com.keqi.blog.mapper.ComUserMapper;
import com.keqi.blog.pojo.CommonUser;
import com.keqi.blog.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComUserServiceImpl implements ComUserService {

    @Autowired
    private ComUserMapper comUserMapper;

    public void setComUserMapper(ComUserMapper comUserMapper) {
        this.comUserMapper = comUserMapper;
    }

    @Override
    public boolean addComUser(String name, String pwd) {
        return comUserMapper.addComUser(name, pwd);
    }

    @Override
    public CommonUser getComUserByN_P(String name, String pwd) {
        return comUserMapper.getComUserByN_P(name, pwd);
    }
}
