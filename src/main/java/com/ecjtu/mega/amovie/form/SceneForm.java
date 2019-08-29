package com.ecjtu.mega.amovie.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author mega
 */
@Data
public class SceneForm {

    private Integer id;

    private Integer movieId;

    @NotBlank(message = "电影名不能为空")
    private String movieName;

    private Integer price;

    private Integer seatNum = 166;

    @NotBlank(message = "电影播放时间不能为空")
    private String showtime;

    private String[] bookedSeat;
}
