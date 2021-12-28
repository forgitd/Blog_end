package com.keqi.blog.controller;

import com.keqi.blog.pojo.Blog;
import com.keqi.blog.pojo.Review;
import com.keqi.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BlogController {

    @Autowired
    @Qualifier("blogServiceImpl")
    private BlogService blogService;


    @RequestMapping("/getBlogs")
    public List<Blog> queryBlogList() {
        List<Blog> blogs = blogService.queryBlogList();
        return blogs;
    }

    @RequestMapping("/delBlog")
    public void delBlogById(Integer id) {
        blogService.deleteBlogById(id);
    }
}
