package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Review;

import java.util.List;

/**
 * @author mega
 */
public interface ReviewService {

    /**
     * 发表影评
     *
     * @param review
     * @return
     */
    int publish(Review review);

    /**
     * 显示所有影评
     *
     * @return
     */
    List<Review> getAll();

    /**
     * 删除影评
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据电影id查询影评
     *
     * @param movieId
     * @return
     */
    List<Review> findByMovieId(Integer movieId);
}
