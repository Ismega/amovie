package com.ecjtu.mega.amovie.service;


import com.ecjtu.mega.amovie.entity.User;

public interface UserService {

    //判断保存用户
    boolean register(User user);

    //判断根据id是否查询
    User findById(Integer id);

    //根据昵称查询
    User findByName(String nickname);

    //根据 邮箱登录
    User login(String email, String password);

    //判断用户是否存在
    boolean isExitUser(String nickname);
}
