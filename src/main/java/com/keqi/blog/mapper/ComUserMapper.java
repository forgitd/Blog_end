package com.keqi.blog.mapper;

import com.keqi.blog.pojo.CommonUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ComUserMapper {
    @Insert("insert into user_c (name_c, pwd_c) values (#{name}, #{pwd})")
    boolean addComUser(String name, String pwd);

    @Select("select * from user_c where name_c = #{name} and pwd_c = #{pwd}")
    CommonUser getComUserByN_P(String name, String pwd);
}
