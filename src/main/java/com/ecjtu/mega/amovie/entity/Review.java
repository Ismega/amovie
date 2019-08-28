package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 影评
 */
public class Review {

    private Integer id;
    private String content;
    private Integer movieId;
    private Integer userId;
    private Date createTime;
    /**
     *
     */
    private String nickname;

    public Review(String content, Integer movieId, Integer userId, Date createTime) {
        this.content = content;
        this.movieId = movieId;
        this.userId = userId;
        this.createTime = createTime;
    }

    public Review(Integer id, String content, Integer movieId, Integer userId, Date createTime) {
        this.id = id;
        this.content = content;
        this.movieId = movieId;
        this.userId = userId;
        this.createTime = createTime;
    }
}
