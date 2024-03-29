package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 资讯
 */
public class News {

    private Integer id;
    /**
     * 资讯内容
     */
    private String content;
    private Date createTime;
    private String title;

    public News(String content, Date createTime, String title) {
        this.content = content;
        this.createTime = createTime;
        this.title = title;
    }
}
