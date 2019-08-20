package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Review;

import java.util.List;

public interface ReviewService {

    //发表影评
    int publish(Review review);

    //显示所有影评
    List<Review> getAll();

    //删除影评
    int delete(Integer id);

    List<Review> findByMovieId(Integer movieId);
}
