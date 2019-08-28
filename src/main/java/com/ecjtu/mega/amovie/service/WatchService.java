package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Watch;

import java.util.List;

public interface WatchService {

    int insert(Watch watch);

    List<Watch> findAll();

    List<Watch> findByUserId(Integer userId);

    int deleteWatch(Integer movieId);
}
