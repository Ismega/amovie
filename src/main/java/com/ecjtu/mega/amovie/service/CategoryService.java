package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Category;

import java.util.List;

public interface CategoryService {

    //添加电影类型
    int save(Category category);

    //显示所有电影类型
    List<Category> findAll();

    //根据id查询电影类型
    Category findById(String id);

    //删除电影类型
    int delete(String id);
}
