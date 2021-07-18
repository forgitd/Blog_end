package com.keqi.blog.mapper;

import com.keqi.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User getUser(String name, String pwd);

    @Select("select * from user where user_id = #{id}")
    User checkById(int id);
}
