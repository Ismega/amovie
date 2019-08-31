package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Score;

/**
 * @author mega
 */
public interface RateService {

    /**
     * 评分
     *
     * @param score
     * @return
     */
    int insert(Score score);

    /**
     * 根据用户id和电影id判断是否评分
     *
     * @param userId
     * @param movieId
     * @return
     */
    Score findByUserIdAndMovieId(Integer userId, Integer movieId);
}
