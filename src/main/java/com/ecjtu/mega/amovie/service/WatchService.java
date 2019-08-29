package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Watch;

import java.util.List;

public interface WatchService {

    int insert(Watch watch);

    List<Watch> findAll();

    int deleteWatch(Integer movieId, Integer userId);

    Watch findByMovieId(Integer movieId, Integer userId);
}
