package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.News;

import java.util.List;

/**
 * @author mega
 */
public interface NewService {

    /**
     * 查询所有
     *
     * @return
     */
    List<News> showAll();

    /**
     * 删除资讯
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 更新资讯
     *
     * @param news
     * @return
     */
    int update(News news);

    /**
     * 添加资讯
     *
     * @param news
     * @return
     */
    int save(News news);

    /**
     * 根据id查询资讯
     *
     * @param id
     * @return
     */
    News findById(Integer id);
}
