package com.ecjtu.mega.amovie.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "电影时长不能为空")
    private String duration;
    @NotBlank(message = "导演不能为空")
    private String directors;
    @NotBlank(message = "演员不能为空")
    private String actors;
    private String releaseTime;

    private Integer[] categoryIds;
    /**
     * 电影上映状态，0为已上映，1为未上映
     */
    private Integer status;
    @NotBlank(message = "剧情不能为空")
    private String plot;
    private String poster;
    private String country;
}
