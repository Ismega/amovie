package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    Category findById(String id);

    //添加电影类型
    @Insert("insert into category (id,name) values(#{id},#{name})")
    int save(Category category);

    //根据id删除电影类型
    @Delete("delete from category where id=#{id}")
    int delete(String id);
}
