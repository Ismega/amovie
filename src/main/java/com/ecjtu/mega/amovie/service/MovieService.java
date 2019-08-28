package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Movie;

import java.util.List;

/**
 * @author mega
 */
public interface MovieService {

    /**
     * 显示所有电影信息
     *
     * @return
     */
    List<Movie> showAll();

    /**
     * 根据电影名称查询
     *
     * @param name
     * @return
     */
    List<Movie> findByName(String name);

    /**
     * 添加电影信息
     *
     * @param movie
     * @return
     */
    int save(Movie movie);

    /**
     * 修改电影信息
     *
     * @param movie
     * @return
     */
    int update(Movie movie);

    /**
     * 删除电影信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Movie findById(Integer id);

    /**
     * 根据类型id查询电影
     *
     * @param id
     * @return
     */
    List<Movie> findByCategoryId(Integer id);

    /**
     * 根据上映状态查询电影
     *
     * @return
     */
    List<Movie> findByStatus(Integer status);

    /**
     * 根据用户id查
     *
     * @param userId
     * @return
     */
    List<Movie> findMovieByUserId(Integer userId);
}
