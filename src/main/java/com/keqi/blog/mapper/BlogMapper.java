package com.keqi.blog.mapper;

import com.keqi.blog.pojo.Blog;
import com.keqi.blog.pojo.Review;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    List<Blog> queryBlogList();

    @Delete("DELETE FROM blog\n" +
            "WHERE id=#{id}")
    void deleteBlogById(Integer id);

}
