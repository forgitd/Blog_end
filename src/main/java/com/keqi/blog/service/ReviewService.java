package com.keqi.blog.service;

import com.keqi.blog.pojo.Review;


import java.util.Date;
import java.util.List;

public interface ReviewService {
    List<Review> getReviewByBlogId(Integer id);
    boolean addReview(Integer id_blog, String comment, Date date, String id_user_name);

    void deleteReviewById(Integer id);
    List<Review> getAllReviews();
}
