package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author mega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 场次
 */
public class Scene {

    /**
     * 场次id
     */
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Integer price;
    private Integer seatNum = 166;
    /**
     * 场次时间
     */
    private String showtime;
    private String bookedSeat;

    public Scene(Integer movieId, String movieName, Integer price,
                 Integer seatNum, String showtime, String bookedSeat) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.price = price;
        this.seatNum = seatNum;
        this.showtime = showtime;
        this.bookedSeat = bookedSeat;
    }
}
