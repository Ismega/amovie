package com.ecjtu.mega.amovie.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author mega
 * @date 2019-08-27 20:45
 */
@Data
public class ReviewVo {

    private String content;
    private Integer movieId;
    private Integer userId;
    private Date createTime;
}
