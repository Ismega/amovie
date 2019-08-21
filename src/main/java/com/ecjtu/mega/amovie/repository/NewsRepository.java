package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsRepository {

    //获取所有资讯内容
    @Select("select * from news")
    List<News> findAll();

    //根据id查询资讯
    @Select("select * from news where id=#{id}")
    News findById(Integer id);

    //添加资讯
    @Insert("insert into news (content,create_time) values(#{content},#{createTime})")
    int save(News news);

    @Update("update news set content=#{content},create_time=#{createTime} where id=#{id}")
    int update(News news);

    @Delete("delete from news where id=#{id}")
    int delete(Integer id);
}
