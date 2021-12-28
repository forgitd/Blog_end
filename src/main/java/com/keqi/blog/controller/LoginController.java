package com.keqi.blog.controller;

import com.keqi.blog.pojo.User;
import com.keqi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class LoginController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login_test")
    @ResponseBody
    public User loginController(String username, String password, Model model, HttpServletRequest request, HttpServletResponse response) {

        User user = userService.getUser(username, password);

//        HttpSession httpSession = request.getSession();

        if (user != null) {
//            Cookie cookie = new Cookie("user_id","" + user.getUser_id());
//            cookie.setMaxAge(1000);
//            cookie.setPath("/login_cookie");
//            response.addCookie(cookie);
//            httpSession.setAttribute("user",user);
//            return "redirect:/main";

            return user;
        } else {
//            model.addAttribute("msg", "没有这个用户");
//            return "login";
            return null;
        }
    }

    @RequestMapping("/login_cookie")
    public String loginFromCookie(Model model, HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            model.addAttribute("msg", "没有cookie对象,请重新登录");
            return "login";
        } else {
            String user_id = "";
            for (Cookie c1 : cookies) {
                if ( "user_id".equals(c1.getName())) {
                    user_id = c1.getValue();
                }
            }

            if ("".equals(user_id)) {
                model.addAttribute("msg", "没有需要的cookie对象,请重新登录");
                return "login";
            } else {
                User user = userService.checkById(Integer.parseInt(user_id));
                if (user != null) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("user",user);
                    return "redirect:/main";
                } else {
                    model.addAttribute("msg", "数据库中没有这个用户了,请重新登录");
                    return "login";
                }
            }
        }

    }

    @RequestMapping("/main")
    public String toMainPage() {
        return "main";
    }


}
