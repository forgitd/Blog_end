package com.keqi.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Integer id_review;
    private Integer id_blog;
    private String comment;
    private Date date;
    private String id_user_name;
}
