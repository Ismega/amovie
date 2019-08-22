package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Mapper
@Repository
public interface CategoryRepository {

    /**
     * 查询所有类型
     *
     * @return
     */
    @Select("select * from category")
    List<Category> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    /**
     * 添加电影类型
     *
     * @param category
     * @return
     */
    @Insert("insert into category (name) values(#{name})")
    int save(Category category);

    /**
     * 根据id删除电影类型
     *
     * @param id
     * @return
     */
    @Delete("delete from category where id=#{id}")
    int delete(Integer id);

    /**
     * 修改电影类别
     *
     * @param category
     * @return
     */
    @Update("update category set name=#{name} where id=#{id}")
    int update(Category category);

    /**
     * 插入关系表，根据电影id 和 类型id
     *
     * @param movieId
     * @param categoryId
     * @return
     */
    @Insert("insert into relation (movie_id,category_id) values(#{movieId},#{categoryId})")
    int insertRelation(Integer movieId, Integer categoryId);

    /**
     * 更新类型和电影的关联表
     *
     * @param categoryId
     * @return
     */
    @Update("update relation set movie_id=#{movieId} where category_id=#{categoryId}")
    int updateRelation(Integer categoryId);

    /**
     * 删除类型和电影的关联表
     *
     * @param movieId
     * @return
     */
    @Delete("delete from relation where movie_id=#{movieId}")
    int deleteRelation(Integer movieId);
}
