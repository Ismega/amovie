package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Scene;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SceneRepository {

    @Select("select * from scene")
    List<Scene> findAll();

    @Select("select * from scene where id=#{id}")
    Scene findById(Integer id);

    //更新场次
    @Update("update scene set movie_id=#{movieId},movie_name=#{movieName}," +
            "price=#{price},seat_num=#{seatNum},showtime=#{showtime}," +
            "booked_seat=#{bookedSeat} where id=#{id}")
    int update(Scene scene);

    @Delete("delete from scene where id=#{id}")
    int delete(Integer id);

    @Insert("insert into scene (movie_id,movie_name,price,seat_num,showtime,booked_seat) " +
            "values(#{movieId},#{movieName},#{price},#{seatNum},#{showtime},#{bookedSeat})")
    int save(Scene scene);

    //根据电影id查询场次数
    @Select("select count(*) from scene where movie_id=#{movieId}")
    int findByMovieId(Integer movieId);
}
