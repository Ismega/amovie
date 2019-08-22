package com.ecjtu.mega.amovie.form;

import lombok.Data;

/**
 * @author mega
 */
@Data
public class SceneForm {

    private Integer id;
    private Integer movieId;
    private String movieName;
    private Integer price;
    private Integer seatNum = 166;
    /**
     * 场次时间
     */
    private String showtime;
    private String[] bookedSeat;
}
