package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.News;

import java.util.List;

public interface NewService {

    //查询所有
    List<News> showAll();

    //删除资讯
    int delete(Integer id);

    //更新资讯
    int update(News news);

    //添加资讯
    int save(News news);

}
