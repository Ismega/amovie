package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Scene;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Mapper
@Repository
public interface SceneRepository {

    @Select("select * from scene")
    /**
     * 查询所有场次
     */
    List<Scene> findAll();

    /**
     * 根据id查询场次信息
     *
     * @param id
     * @return
     */
    @Select("select * from scene where id=#{id}")
    Scene findById(Integer id);

    /**
     * 更新场次
     *
     * @param scene
     * @return
     */
    int update(Scene scene);

    /**
     * 根据id删除场次信息
     *
     * @param id
     * @return
     */
    @Delete("delete from scene where id=#{id}")
    int delete(Integer id);

    /**
     * 插入场次
     *
     * @param scene
     * @return
     */
    @Insert("insert into scene (movie_id,movie_name,price,seat_num,showtime,booked_seat) " +
            "values(#{movieId},#{movieName},#{price},#{seatNum},#{showtime},#{bookedSeat})")
    int save(Scene scene);

    /**
     * 根据电影id查询场次数
     *
     * @param movieId
     * @return
     */
    @Select("select * from scene where movie_id=#{movieId}")
    List<Scene> findByMovieId(Integer movieId);
}
