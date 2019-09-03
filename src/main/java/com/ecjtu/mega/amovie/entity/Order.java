package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mega
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private Integer status;
    private Integer userId;
    private Date createTime;
    /**
     * 场次id
     */
    private Integer sceneId;
    /**
     * 所购票数
     */
    private Integer ticketNum;
    private Integer totalPrice;
    /**
     * 当前用户预定的座位号
     */
    private String seat;
    private String movieName;
    private String uuid;

    public Order(Integer status, Integer userId, Date createTime,
                 Integer sceneId, Integer ticketNum, Integer totalPrice, String seat) {
        this.status = status;
        this.userId = userId;
        this.createTime = createTime;
        this.sceneId = sceneId;
        this.ticketNum = ticketNum;
        this.totalPrice = totalPrice;
        this.seat = seat;
    }

}
