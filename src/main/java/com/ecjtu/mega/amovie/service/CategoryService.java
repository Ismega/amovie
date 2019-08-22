package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Category;
import com.ecjtu.mega.amovie.entity.Movie;

import java.util.List;

/**
 * @author mega
 */
public interface CategoryService {

    /**
     * 添加电影类型
     *
     * @param category
     * @return
     */
    int save(Category category);

    /**
     * 显示所有电影类型
     *
     * @return
     */
    List<Category> findAll();

    /**
     * 根据id查询电影类型
     *
     * @param id
     * @return
     */
    Category findById(Integer id);

    /**
     * 删除电影类型
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改电影类别
     *
     * @param category
     * @return
     */
    int update(Category category);

    /**
     * 插入类型和电影id
     *
     * @param movie
     * @param categoryIds
     * @return
     */
    int insertRelation(Movie movie, Integer[] categoryIds);

    /**
     * 修改电影的类型
     *
     * @param movie
     * @param categoryIds
     * @return
     */
    int updateRelation(Movie movie, Integer[] categoryIds);

    /**
     * 删除电影和类型关系表
     *
     * @param movieId
     * @return
     */
    int deleteRelation(Integer movieId);
}
