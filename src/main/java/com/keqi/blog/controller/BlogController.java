package com.keqi.blog.controller;

import com.keqi.blog.pojo.Blog;
import com.keqi.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    @Qualifier("blogServiceImpl")
    private BlogService blogService;


    @RequestMapping("/getBlogs")
    public List<Blog> queryBlogList() {
        List<Blog> blogs = blogService.queryBlogList();
        return blogs;
    }

}
