package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Scene;

import java.util.List;

/**
 * @author mega
 */
public interface SceneService {

    /**
     * 查询所有场次
     *
     * @return
     */
    List<Scene> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Scene findById(Integer id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 更新
     *
     * @param scene
     * @return
     */
    int update(Scene scene);

    /**
     * 保存
     *
     * @param scene
     * @return
     */
    int save(Scene scene);

    /**
     * 根据电影id查询场次数
     *
     * @param movieId
     * @return
     */
    int findByMovieId(Integer movieId);
}
