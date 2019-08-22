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
 * 电影类型
 */
public class Category {

    private Integer id;
    /**
     * 影评类型名称
     */
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
