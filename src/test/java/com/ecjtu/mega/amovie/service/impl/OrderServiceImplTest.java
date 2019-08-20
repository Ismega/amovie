package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Order;
import com.ecjtu.mega.amovie.service.OrderService;
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
public class OrderServiceImplTest {

    @Autowired
    private OrderService service;

    @Test
    public void findAll() {
        List<Order> orders = service.findAll();
        Assert.assertNotNull(orders);
    }

    @Test
    public void delete() {
        int res = service.delete(3);
        Assert.assertEquals(1, res);
    }

    @Test
    public void save() {
        Order order = new Order(1, 2, new Date(), 2,
                4, 80, "[A1,A2,A3,A4]");
        int res = service.save(order);
        Assert.assertEquals(1, res);
    }

    @Test
    public void findById() {
        Order order = service.findById(1);
        Assert.assertNotNull(order);
    }

    @Test
    public void update() {
        Order order = new Order(1, 2, new Date(), 2,
                5, 200, "[A1,A2,A3,A4,A5]");
        int res = service.update(order);
        Assert.assertNotEquals(0, res);
    }
}