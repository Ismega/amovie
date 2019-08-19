package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {

    //保存用户
    @Insert("Insert into user(nickname,email,password,salt,phone,gender,role) " +
            "values(#{nickname},#{email},#{password},#{salt},#{phone},#{gender},#{role})")
    int save(User user);

    //根据id查询用户
    @Select("select * from user where id=#{id}")
  /*  @Results({
            @Result(property="nickname",column = "nickname"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "gender",column = "gender")
    })*/
    User findById(Integer id);

    //根据昵称查询用户
    @Select("select * from user where nickname=#{nickname}")
    User findByUserName(String nickname);

    //根据邮箱登录
    @Select("select * from user where email=#{email}")
    User findByEmail(String email);

    /*@Update("update user set nickname$={nickname},email=${email},")
    void updateUser(User user);*/
}
