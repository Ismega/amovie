package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scene {

    //场次id
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Integer price;
    private Integer seatNum = 166;
    private Date showtime;
    private Integer bookedSeat;
}
