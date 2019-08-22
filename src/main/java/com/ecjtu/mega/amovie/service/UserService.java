package com.ecjtu.mega.amovie.service;


import com.ecjtu.mega.amovie.entity.User;

/**
 * @author mega
 */
public interface UserService {

    /**
     * 判断保存用户
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 判断根据id是否查询
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据 邮箱登录
     *
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     * 根据 昵称查询,判断用户是否存在
     *
     * @param nickname
     * @return
     */
    boolean isExitUser(String nickname);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delete(Integer id);
}
