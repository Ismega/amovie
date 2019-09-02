package com.ecjtu.mega.amovie.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author mega
 * @date 2019-09-02 18:59
 */
@Data
public class OrderVo {

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
}
