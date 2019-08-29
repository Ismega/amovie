package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Score;

/**
 * @author mega
 */
public interface RateService {

    /**
     * 添加评分
     *
     * @param score
     * @return
     */
    int insert(Score score);
}
