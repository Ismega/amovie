package com.ecjtu.mega.amovie.vo;

import lombok.Data;

/**
 * @author mega
 * @date 2019-09-02 15:06
 */
@Data
public class TicketVo {
    //总价
    private Integer cost;
    private Integer price;
    private Integer num;
    private String sits;
    private Integer sceneId;
    private String movieName;
    private Integer movieId;
}
