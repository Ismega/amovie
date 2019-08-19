package com.ecjtu.mega.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer id;
    //影评类型名称
    private String name;
}
