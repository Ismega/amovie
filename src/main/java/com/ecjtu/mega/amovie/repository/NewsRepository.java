package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Mapper
@Repository
public interface NewsRepository {

    /**
     * 获取所有资讯内容
     *
     * @return
     */
    @Select("select * from news")
    List<News> findAll();

    /**
     * 根据id查询资讯
     *
     * @param id
     * @return
     */
    @Select("select * from news where id=#{id}")
    News findById(Integer id);

    /**
     * 添加资讯
     *
     * @param news
     * @return
     */
    @Insert("insert into news (content,create_time,title) values(#{content},#{createTime},#{title})")
    int save(News news);

    /**
     * 更新资讯
     *
     * @param news
     * @return
     */
    @Update("update news set content=#{content},create_time=#{createTime},title=#{title} where id=#{id}")
    int update(News news);

    /**
     * 删除资讯
     *
     * @param id
     * @return
     */
    @Delete("delete from news where id=#{id}")
    int delete(Integer id);
}
