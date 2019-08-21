package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Scene;

import java.util.List;

public interface SceneService {

    List<Scene> findAll();

    Scene findById(Integer id);

    int delete(Integer id);

    int update(Scene scene);

    int save(Scene scene);

    //根据电影id查询场次数
    int findByMovieId(Integer movieId);
}
