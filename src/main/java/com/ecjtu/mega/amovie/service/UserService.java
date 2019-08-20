package com.ecjtu.mega.amovie.service;


import com.ecjtu.mega.amovie.entity.User;

public interface UserService {

    //判断保存用户
    boolean register(User user);

    //判断根据id是否查询
    User findById(Integer id);

    //根据 邮箱登录
    User login(String email, String password);

    //根据 昵称查询,判断用户是否存在
    boolean isExitUser(String nickname);

    int update(User user);

    int delete(Integer id);
}
