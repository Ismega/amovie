package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Review;
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
public interface ReviewRepository {

    /**
     * 插入影评
     *
     * @param review
     * @return
     */
    @Insert("insert into review (content,movie_id,user_id,create_time) values(#{content},#{movieId},#{userId},#{createTime})")
    int save(Review review);

    /**
     * 查询所有影评信息
     *
     * @return
     */
    @Select("select * from review")
    List<Review> findAll();

    /**
     * 根据id删除影评
     *
     * @param id
     * @return
     */
    @Delete("delete from review where id=#{id}")
    int delete(Integer id);

    /**
     * #{}里面是review对象的值，movie_id=#{movieId}，前半段是sql语句，后半段是变量
     *
     * @param review
     * @return
     */
    int update(Review review);

    /**
     * 根据电影id 查询影评
     *
     * @param movieId
     * @return
     */
    @Select("select * from review where movie_id=#{movieId}")
    List<Review> findByMovieId(Integer movieId);
}
