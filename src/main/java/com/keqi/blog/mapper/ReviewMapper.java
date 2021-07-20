package com.keqi.blog.mapper;

import com.keqi.blog.pojo.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {
    @Select("select * from review where id_blog = #{id}")
    List<Review> getReviewByBlogId(Integer id);
    @Insert("insert into review (id_blog,comment,date,id_user_c) values(" +
            " #{id_blog},#{comment},#{date},#{id_user_c})")
    boolean addReview(Integer id_blog, String comment, Date date, Integer id_user_c);
}
