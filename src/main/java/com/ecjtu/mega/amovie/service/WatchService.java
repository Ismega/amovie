package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Watch;

import java.util.List;

/**
 * @author mega
 */
public interface WatchService {

    /**
     * 添加至观看列表
     *
     * @param watch
     * @return
     */
    int insert(Watch watch);

    /**
     * 获取所有观看列表
     * @return
     */
    List<Watch> findAll();

    /**
     * 从观看列表移除
     * @param movieId
     * @param userId
     * @return
     */
    int deleteWatch(Integer movieId, Integer userId);

    /**
     * 根据电影id查询
     * @param movieId
     * @param userId
     * @return
     */
    Watch findByMovieId(Integer movieId, Integer userId);
}
