package com.ecjtu.mega.amovie.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {

    private Integer id;
    private String name;
    /**
     * 电影时长
     */
    private String duration;
    private String directors;
    private String actors;
    private String releaseTime;

    private Integer[] categoryIds;
    /**
     * 电影上映状态，0为已上映，1为未上映
     */
    private Integer status;
    private String plot;
    private String poster;
    private String country;
}
