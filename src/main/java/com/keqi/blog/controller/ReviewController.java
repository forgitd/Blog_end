package com.keqi.blog.controller;

import com.keqi.blog.pojo.Review;
import com.keqi.blog.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    @Qualifier("reviewServiceImpl")
    private ReviewService reviewService;

    @RequestMapping("/addReview")
    public boolean addReview1(Integer id_blog, String comment, Integer id_user_c) {


        return reviewService.addReview(id_blog, comment, new Date(), id_user_c);
    }

    @RequestMapping("/getReview")
    public List<Review> getReview(Integer id) {
        List<Review> reviews = reviewService.getReviewByBlogId(id);
        if (reviews != null) {
            return reviews;
        } else {
            return null;
        }
    }
}
