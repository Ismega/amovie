package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService service;

    @Test
    public void register() {
        User user = new User("陈佳美", "1691463250@qq.com",
                "123456", "1234", "1877945", 0, 2);
        boolean result = service.register(user);
        Assert.assertEquals(true, result);
    }

    @Test
    public void login() {
        User user = service.login("1691463250@qq.com", "123456");
        Assert.assertNotNull(user);
    }

    @Test
    public void isExitUser() {
        boolean result = service.isExitUser("mega");
        Assert.assertEquals(true, result);
    }

    @Test
    public void findByName() {
        User user = service.findByName("肖莉岚");
        Assert.assertNotNull(user);
    }
}