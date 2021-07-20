package com.keqi.blog.controller;

import com.keqi.blog.pojo.CommonUser;
import com.keqi.blog.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class User_C_Controller {

    @Autowired
    @Qualifier("comUserServiceImpl")
    private ComUserService comUserService;

    public void setComUserService(ComUserService comUserService) {
        this.comUserService = comUserService;
    }

    @RequestMapping("register")
    @ResponseBody
    public boolean register_user_c(String username, String password) {
        CommonUser commonUser = comUserService.getComUserByN_P(username, password);
        if (commonUser == null) {
            if (username != null && password != null) {
                comUserService.addComUser(username, password);
                return true;
            }
        }

        return  false;
    }

    @RequestMapping("login_common")
    @ResponseBody
    public CommonUser CommonUserLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
        CommonUser commonUser = comUserService.getComUserByN_P(username, password);
        if (commonUser != null) {
            return commonUser;
        } else {
            return null;
        }
    }
}
