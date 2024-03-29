package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Rate;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.repository.MovieRepository;
import com.ecjtu.mega.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mega
 */
@Transactional(rollbackFor = {CommonException.class, NotFoundException.class})
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    /**
     * 查询所有电影信息
     *
     * @return
     */
    @Override
    public List<Movie> showAll() {
        return repository.findAll();
    }

    /**
     * 根据名字查询电影信息
     *
     * @param name
     * @return
     */
    @Override
    public List<Movie> findByMovieName(String name) {
        return repository.findByMovieName(name);
    }

    /**
     * 添加电影信息
     *
     * @param movie
     * @return
     */
    @Override
    public int save(Movie movie) {
        return repository.save(movie);
    }

    /**
     * 修改电影信息
     *
     * @param movie
     * @return
     */
    @Override
    public int update(Movie movie) {
        return repository.update(movie);
    }

    /**
     * 根据id删除电影信息
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    /**
     * 根据id查询电影
     *
     * @param id
     * @return
     */
    @Override
    public Movie findById(Integer id) {
        return repository.findById(id);
    }

    /**
     * 根据类型id查询电影
     *
     * @param id
     * @return
     */
    @Override
    public List<Movie> findByCategoryId(Integer id) {
        return repository.findByCategoryId(id);
    }

    @Override
    public List<Rate> findByStatus(Integer status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Movie> findMovieByUserId(Integer userId) {
        return repository.findMovieByUserId(userId);
    }

    @Override
    public List<Movie> findByActor(String actor) {
        return repository.findByActor(actor);
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return repository.findByDirector(director);
    }

    @Override
    public List<Movie> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Movie> findByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<Rate> findMovieAndAvgScore() {
        return repository.findMovieAndAvgScore();
    }

    @Override
    public List<Rate> findMovieAndAvgScoreSort() {
        return repository.findMovieAndAvgScoreSort();
    }

    @Override
    public Rate findMovieAndAvgScoreByMovieId(Integer movieId) {
        return repository.findMovieAndAvgScoreByMovieId(movieId);
    }

    @Override
    public List<Rate> findMovieAndAvgScoreByUserId(Integer userId) {
        return repository.findMovieAndAvgScoreByUserId(userId);
    }
}
