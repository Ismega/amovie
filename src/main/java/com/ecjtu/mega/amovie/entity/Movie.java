package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 电影详情
 */
public class Movie {

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

    public Movie(String name, String duration,
                 String directors, String actors,
                 Date releaseTime,
                 Integer status, String plot, String country) {
        this.name = name;
        this.duration = duration;
        this.directors = directors;
        this.actors = actors;
        this.releaseTime = releaseTime;
        this.status = status;
        this.plot = plot;
        this.country = country;
    }

    public Movie(Integer id, String name, String duration,
                 String directors, String actors, Date releaseTime,
                 Integer status, String plot, String country) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.directors = directors;
        this.actors = actors;
        this.releaseTime = releaseTime;
        this.status = status;
        this.plot = plot;
        this.country = country;
    }
}
