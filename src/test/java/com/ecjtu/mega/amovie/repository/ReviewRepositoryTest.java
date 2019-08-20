package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository repository;

    @Test
    public void save() {
        String str = "2016-02-03";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Review review = null;
        try {
            review = new Review("电影差评", 2, 11, sdf.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = repository.save(review);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findAll() {
        List<Review> reviews = repository.findAll();
        Assert.assertNotNull(reviews);
    }

    @Test
    public void delete() {
        int result = repository.delete(3);
        Assert.assertEquals(1, result);
    }

    @Test
    public void update() {
        Review review = new Review(2, "电影差评", 2, 11, new Date());
        int result = repository.update(review);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findById() {
        List<Review> reviews = repository.findByMovieId(1);
        Assert.assertNotNull(reviews);
    }
}