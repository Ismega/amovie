package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.repository.UserRepository;
import com.ecjtu.mega.amovie.service.UserService;
import com.ecjtu.mega.amovie.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mega
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    /**
     * 判断用户是否注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        User user1 = repository.findByEmail(user.getEmail());
        if (user1 == null) {
            if (user.getEmail() != null) {
                String salt = MD5Utils.getSalt();
                String encryptPassword = MD5Utils.md5(user.getPassword(), salt);
                user.setSalt(salt);
                user.setPassword(encryptPassword);
                int result = repository.save(user);
                if (result != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public User login(String email, String password) {
        User user = repository.findByEmail(email);
        if (user != null) {
            String salt = user.getSalt();
            String encryptPassword = MD5Utils.md5(password, salt);
            if (user.getPassword().equals(encryptPassword)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 判断用户是否存在
     *
     * @param nickname
     * @return
     */
    @Override
    public boolean isExitUser(String nickname) {
        User user = repository.findByUserName(nickname);
        return user != null;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return repository.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return repository.deleteById(id);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return repository.findById(id);
    }
}
