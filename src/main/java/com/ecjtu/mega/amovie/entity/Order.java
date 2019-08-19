package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private Integer status;
    private Integer userId;
    private Date createTime;
    //场次id
    private Integer sceneId;
    //所购票数
    private Integer ticketNum;
    private Integer totalPrice;
    //当前用户预定的座位号
    private String bookedSeated;
}
