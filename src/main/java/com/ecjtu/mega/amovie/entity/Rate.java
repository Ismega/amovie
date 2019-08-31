package com.ecjtu.mega.amovie.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author mega
 * @date 2019-08-30 10:32
 */

/**
 * 排行榜
 */
@Data
public class Rate {

    private Integer id;
    private String name;
    /**
     * 电影时长
     */
    private String duration;
    private String directors;
    private String actors;
    /**
     * 电影上映日期
     */
    private Date releaseTime;
    /**
     * 电影上映状态，1为已上映，0为未上映
     */
    private Integer status;
    /**
     * 剧情
     */
    private String plot;
    /**
     * 电影海报
     */
    private String poster;
    private String country;
    private List<Category> categories;

    /**
     * 评分
     */
    private Double score = 0.0;

    /**
     * 评论数量
     */
    private int count;
}
