package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.repository.ReviewRepository;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceImplTest {
    @Autowired
    private ReviewService service;

    @Test
    public void getAll() {
        List<Review> reviews = service.getAll();
        Assert.assertNotNull(reviews);
    }

    @Test

    public void publish() {
        Review review = new Review(2, "电影好评", 2, 11, new Date());
        int result = service.publish(review);
        Assert.assertEquals(1, result);
    }

    @Test
    public void delete() {
        service.delete(4);
    }

    @Test
    public void findByMovieId() {
        List<Review> reviews = service.findByMovieId(2);
        Assert.assertNotNull(reviews);
    }
}