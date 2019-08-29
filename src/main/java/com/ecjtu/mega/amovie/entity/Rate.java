package com.ecjtu.mega.amovie.entity;

import lombok.Data;

/**
 * @author mega
 * @date 2019-08-29 09:08
 */
@Data
public class Rate {

    /**
     * 评分id
     */
    private Integer id;

    private Integer movieId;

    private Integer userId;
    /**
     * 评分
     */
    private Integer score;
}
