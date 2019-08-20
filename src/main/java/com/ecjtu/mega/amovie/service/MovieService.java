package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Movie;

import java.util.List;

public interface MovieService {

    //显示所有电影信息
    List<Movie> showAll();

    //根据电影名称查询
    Movie findByName(String name);

    //添加电影信息
    int save(Movie movie);

    //修改电影信息
    int update(Movie movie);

    //删除电影信息
    int delete(Integer id);
}
