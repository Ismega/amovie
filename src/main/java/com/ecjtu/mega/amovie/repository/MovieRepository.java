package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Movie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieRepository {

    //查询所有电影详情
    @Select("select * from movie")
    List<Movie> findAll();

    //根据id查询电影
    @Select("select * from movie where id=#{id}")
    Movie findById(Integer id);

    //根据电影名字查询电影
    @Select("select * from movie where name=#{name}")
    Movie findByMovieName(String name);

    //根据电影id修改电影信息
    @Update("update movie set name=#{name},duration=#{duration},directors=#{directors}," +
            "actors=#{actors},release_time=#{releaseTime},category_id=#{categoryId}," +
            "status=#{status},plot=#{plot},poster=#{poster},country=#{country} where id=#{id}")
    int update(Movie movie);

    //根据电影id删除电影信息
    @Delete("delete from movie where id=#{id}")
    int delete(Integer id);

    //保存电影信息
    @Insert("insert into movie (name,duration,directors,actors,release_time,category_id,status,plot,country) " +
            "values(#{name},#{duration},#{directors},#{actors},#{releaseTime},#{categoryId},#{status},#{plot},#{country})")
    int save(Movie movie);

}
