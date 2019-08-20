package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Category;
import com.ecjtu.mega.amovie.service.CategoryService;
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
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void save() {
        Category category = new Category("8", "恐怖");
        int res = service.save(category);
        Assert.assertEquals(1, res);
    }

    @Test
    public void findAll() {
        List<Category> categoryList = service.findAll();
        Assert.assertNotNull(categoryList);
    }

    @Test
    public void findById() {
        Category category = service.findById("1");
        Assert.assertNotNull(category);

    }

    @Test
    public void delete() {
        int res = service.delete("7");
        Assert.assertEquals(1, res);
    }
}