package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Rate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Mapper
@Repository
public interface MovieRepository {

    /**
     * 查询所有电影详情
     *
     * @return
     */
    List<Movie> findAll();

    /**
     * 根据id查询电影
     *
     * @param id
     * @return
     */
    Movie findById(Integer id);

    /**
     * 根据电影名字查询电影
     *
     * @param name
     * @return
     */
    List<Movie> findByMovieName(String name);

    /**
     * 根据电影id修改电影信息
     *
     * @param movie
     * @return
     */
    int update(Movie movie);

    /**
     * 根据电影id删除电影信息
     *
     * @param id
     * @return
     */
    @Delete("delete from movie where id=#{id}")
    int delete(Integer id);

    /**
     * 保存电影信息
     *
     * @param movie
     * @return
     */
    @Insert("insert into movie (name,duration,directors,actors,release_time,status,plot,poster,country) " +
            "values(#{name},#{duration},#{directors},#{actors},#{releaseTime},#{status},#{plot},#{poster},#{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(Movie movie);

    /**
     * 根据类别查询电影
     *
     * @param categoryId
     * @return
     */
    List<Movie> findByCategoryId(Integer categoryId);

    /**
     * 根据状态查询电影
     *
     * @param status
     * @return
     */
    @Select("select * from movie where status=#{status}")
    List<Movie> findByStatus(Integer status);

    /**
     * 观看列表根据用户id查询电影列表
     *
     * @param userId
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    List<Movie> findMovieByUserId(Integer userId);

    /**
     * 根据演员查询电影
     *
     * @param actor
     * @return
     */
    List<Movie> findByActor(String actor);

    /**
     * 根据导演查询电影
     * @param director
     * @return
     */
    List<Movie> findByDirector(String director);

    /**
     * 根据类型查询电影
     * @param category
     * @return
     */
    List<Movie> findByCategory(String category);

    /**
     * 根据国家查询电影
     * @param country
     * @return
     */
    List<Movie> findByCountry(String country);

    /**
     * 查询电影和计算平均分
     *
     * @return
     */
    List<Rate> findMovieAndAvgScore();

    /**
     * @param movieId
     * @return
     */
    Rate findMovieAndAvgScoreByMovieId(Integer movieId);

    /**
     * 查询电影和计算平均分 并根据评分排序
     *
     * @return
     */
    List<Rate> findMovieAndAvgScoreSort();
}
