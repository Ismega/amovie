package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mega
 * @date 2019-08-27 09:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    private Integer id;
    private Integer movieId;
    private Integer userId;
    private Integer score;

    public Score(Integer movieId, Integer userId, Integer score) {
        this.movieId = movieId;
        this.userId = userId;
        this.score = score;
    }
}
