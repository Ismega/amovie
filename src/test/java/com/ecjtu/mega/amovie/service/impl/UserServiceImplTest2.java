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
public class UserServiceImplTest2 {

    @Autowired
    private UserService service;

    @Test
    public void update() {
        int result = service.update(new User(12, "肖莉岚2", "18779457989", 0, 1));
        Assert.assertEquals(1, result);
    }

    @Test
    public void delete() {
        service.delete(15);
    }
}