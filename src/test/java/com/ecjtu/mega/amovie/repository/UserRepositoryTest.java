package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void save() {
        User user = new User("肖莉岚", "123456@qq.com", "123456", "cjm", "1877945", 0, 2);
        repository.save(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void findById() {
        User user = repository.findById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void findByUserName() {
        User user = repository.findByUserName("mega");
        Assert.assertNotNull(user);
    }

    @Test
    public void findByEmail() {
        User user = repository.findByEmail("169146");
        Assert.assertNotNull(user);
    }

    @Test
    public void updateUser() {
        int result = repository.updateUser(new User(12, "mega2", "18779457989", 0, 1));
        Assert.assertEquals(1, result);

    }

    @Test
    public void deleteById() {
        repository.deleteById(14);
    }
}