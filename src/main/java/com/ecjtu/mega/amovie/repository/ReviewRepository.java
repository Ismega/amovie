package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Review;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviewRepository {

    @Insert("insert into review (content,movie_id,user_id,create_time) values(#{content},#{movieId},#{userId},#{createTime})")
    int save(Review review);

    @Select("select * from review")
    List<Review> findAll();

    @Delete("delete from review where id=#{id}")
    int delete(Integer id);

    //#{}里面是review对象的值，movie_id=#{movieId}，前半段是sql语句，后半段是变量
    @Update("update review set content=#{content},movie_id=#{movieId},user_id=#{userId},create_time=#{createTime} where id=#{id")
    int update(Review review);

    //根据电影id 查询影评
    @Select("select * from review where movie_id=#{movieId}")
    List<Review> findByMovieId(Integer MovieId);
}
