package com.ecjtu.mega.amovie.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {

    private Integer id;
    private String name;
    //电影时长
    private String duration;
    private String directors;
    private String actors;
    //电影上映日期
    private String releaseTime;
    //电影类型
    private Integer[] categoryIds;
    //电影上映状态，0为已上映，1为未上映
    private Integer status;
    //剧情
    private String plot;
    //电影海报
    private String poster;
    private String country;
}
