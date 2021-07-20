package com.keqi.blog.service.impl;

import com.keqi.blog.mapper.ReviewMapper;
import com.keqi.blog.pojo.Review;
import com.keqi.blog.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public void setReviewMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<Review> getReviewByBlogId(Integer id) {
        return reviewMapper.getReviewByBlogId(id);
    }

    @Override
    public boolean addReview(Integer id_blog, String comment, Date date, Integer id_user_c) {
        return reviewMapper.addReview(id_blog, comment, date, id_user_c);
    }
}
