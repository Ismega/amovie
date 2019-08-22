package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author mega
 */
@Mapper
@Repository
public interface UserRepository {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Insert("Insert into user(nickname,email,password,salt,phone,gender,role) " +
            "values(#{nickname},#{email},#{password},#{salt},#{phone},#{gender},#{role})")
    int save(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 根据昵称查询用户
     *
     * @param nickname
     * @return
     */
    @Select("select * from user where nickname=#{nickname}")
    User findByUserName(String nickname);

    /**
     * 根据邮箱登录
     *
     * @param email
     * @return
     */
    @Select("select * from user where email=#{email}")
    User findByEmail(String email);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Update("update user set nickname=#{nickname},phone=#{phone},gender=#{gender},role=#{role} where id=#{id}")
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    int deleteById(Integer id);
}
