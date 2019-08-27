package com.ecjtu.mega.amovie.form;

import lombok.Data;

import java.util.Date;

/**
 * @author mega
 * @date 2019-08-27 20:41
 */
@Data
public class ReviewForm {

    private String content;
    private Integer movieId;
    private Integer userId;
    private Date createTime;


}
