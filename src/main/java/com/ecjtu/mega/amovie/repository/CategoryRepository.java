package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryRepository {

    //查询所有类型
    @Select("select * from category")
    List<Category> findAll();

    //根据id查询
    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    //添加电影类型
    @Insert("insert into category (name) values(#{name})")
    int save(Category category);

    //根据id删除电影类型
    @Delete("delete from category where id=#{id}")
    int delete(Integer id);

    //修改电影类别
    @Update("update category set name=#{name} where id=#{id}")
    int update(Category category);
}
