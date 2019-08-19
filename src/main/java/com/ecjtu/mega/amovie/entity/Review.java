package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 影评
 */
public class Review {

    private Integer id;
    //影评内容
    private String content;
    private Integer movieId;
    private Integer userId;
    //影评创建时间
    private Date createTime;
}
