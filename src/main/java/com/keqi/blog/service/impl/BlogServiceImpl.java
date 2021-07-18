package com.keqi.blog.service.impl;

import com.keqi.blog.mapper.BlogMapper;
import com.keqi.blog.pojo.Blog;
import com.keqi.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    @Qualifier("blogMapper")
    private BlogMapper blogMapper;

    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public List<Blog> queryBlogList() {
        return blogMapper.queryBlogList();
    }
}
