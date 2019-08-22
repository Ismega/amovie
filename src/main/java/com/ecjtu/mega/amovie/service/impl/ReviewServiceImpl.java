package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.repository.ReviewRepository;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author mega
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    /**
     * 发表影评 保存
     *
     * @param review
     * @return
     */
    @Override
    public int publish(Review review) {
        Date date = new Date();
        review.setCreateTime(date);
        return repository.save(review);

    }

    /**
     * 获取所有影评内容
     *
     * @return
     */
    @Override
    public List<Review> getAll() {
        return repository.findAll();
    }

    /**
     * 根据id删除评论
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    /**
     * 根据电影id，发表影评
     *
     * @param movieId
     * @return
     */
    @Override
    public List<Review> findByMovieId(Integer movieId) {
        return repository.findByMovieId(movieId);
    }
}
