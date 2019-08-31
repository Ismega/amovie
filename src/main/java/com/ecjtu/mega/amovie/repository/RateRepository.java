package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RateRepository {

    /**
     * 添加评分
     *
     * @param score
     * @return
     */
    @Insert("insert into score (movie_id,user_id,score) values(#{movieId},#{userId},#{score})")
    int insert(Score score);

    @Select("select * from score where user_id=#{userId} and movie_id=#{movieId}")
    Score findByUserIdAndMovieId(Integer userId, Integer movieId);
}
