package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mega
 * @date 2019-08-28 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Watch {
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private Date createTime;

}
