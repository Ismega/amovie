package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Category;
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
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findAll() {
        List<Category> categories = repository.findAll();
        Assert.assertNotNull(categories);
    }

    @Test
    public void findById() {
        Category category = repository.findById(1);
        Assert.assertNotNull(category);
    }

    @Test
    public void save() {
        Category category = new Category("动漫");
        int res = repository.save(category);
        Assert.assertEquals(1, res);
    }

    @Test
    public void delete() {
        int res = repository.delete(4);
        Assert.assertEquals(1, res);
    }
}