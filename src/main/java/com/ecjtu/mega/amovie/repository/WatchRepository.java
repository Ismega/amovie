package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Watch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Repository
@Mapper
public interface WatchRepository {

    /**
     * 添加到观看列表
     *
     * @param watch
     * @return
     */
    @Insert("insert into watch (user_id,movie_id,create_time) values(#{userId},#{movieId},#{createTime})")
    int insert(Watch watch);

    @Select("select * from watch")
    List<Watch> findAll();

    /**
     * 根据电影id查询观看列表
     *
     * @param movieId
     * @return
     */
    @Select("select * from watch where movie_id=#{movieId} and user_id=#{userId}")
    Watch findByMovieId(Integer movieId, Integer userId);

    /**
     * 从观看列表移除
     *
     * @param movieId
     * @return
     */
    @Delete("delete from watch where movie_id=#{movieId} and user_id=#{userId}")
    int deleteWatch(Integer movieId, Integer userId);
}
