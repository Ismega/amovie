package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.repository.UserRepository;
import com.ecjtu.mega.amovie.service.UserService;
import com.ecjtu.mega.amovie.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean register(User user) {
        String salt = MD5Utils.getSalt();
        String encryptPassword = MD5Utils.md5(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(encryptPassword);
        try {
            int result = repository.save(user);
            if (result != 0) {
                return true;
            }
        } catch (DuplicateKeyException e) {
            throw new CommonException("邮箱已存在");
        }

        return false;
    }

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

    @Override
    public boolean isExitUser(String nickname) {
        User user = repository.findByUserName(nickname);
        return user != null;
    }

    @Override
    public User findByName(String nickname) {
        return repository.findByUserName(nickname);
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id);
    }
}
