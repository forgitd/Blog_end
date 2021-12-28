package com.keqi.blog.controller;

import com.keqi.blog.pojo.Review;
import com.keqi.blog.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    @Qualifier("reviewServiceImpl")
    private ReviewService reviewService;

    @RequestMapping("/addReview")
    public boolean addReview1(Integer id_blog, String comment, String id_user_name) {


        return reviewService.addReview(id_blog, comment, new Date(), id_user_name);
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

    @RequestMapping("/deleteReview")
    public void delRev(Integer id) {
        reviewService.deleteReviewById(id);
    }
    @RequestMapping("/getRes")
    public List<Review> getRev() {
        return reviewService.getAllReviews();
    }
}
