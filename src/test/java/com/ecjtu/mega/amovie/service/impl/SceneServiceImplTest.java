package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Scene;
import com.ecjtu.mega.amovie.service.SceneService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SceneServiceImplTest {

    @Autowired
    private SceneService service;

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
        Scene scene = new Scene();
        scene.setMovieId(15);
        scene.setMovieName("暮光之城");
        scene.setId(5);
        int result = service.update(scene);
        Assert.assertEquals(1, result);
    }

    @Test
    public void save() {
    }

    @Test
    public void findByMovieId() {
    }
}