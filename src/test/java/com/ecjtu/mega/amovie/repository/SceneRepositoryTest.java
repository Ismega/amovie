package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Scene;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SceneRepositoryTest {

    @Autowired
    private SceneRepository repository;

    @Test
    public void findAll() {
        List<Scene> scenes = repository.findAll();
        System.out.println(scenes);
    }

    @Test
    public void findById() {
        Scene scene = repository.findById(1);
        System.out.println(scene);
    }

    @Test
    public void update() {
        Scene scene = new Scene();
        scene.setMovieId(15);
        scene.setMovieName("从你的全世界路过");
        scene.setId(2);
        int result = repository.update(scene);
        Assert.assertEquals(1, result);
    }

    @Test
    public void delete() {
        int res = repository.delete(3);
        Assert.assertEquals(1, res);
    }

    @Test
    public void save() {
        Scene scene = new Scene(6, "咒怨", 30, 9, "150", "[A1,B5,");
        int res = repository.save(scene);
        Assert.assertEquals(1, res);
    }

    @Test
    public void findByMovieId() {
        int res = repository.findByMovieId(4);
        Assert.assertEquals(2, res);
    }
}