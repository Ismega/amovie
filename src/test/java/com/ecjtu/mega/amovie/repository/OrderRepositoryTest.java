package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void add() {
        Order order = new Order(0, 2, new Date(), 2,
                4, 80, "[A1,A2,A3,A4]");
        int res = repository.add(order);
        Assert.assertEquals(1, res);
    }

   /* @Test
    public void update() {
        Order order = new Order(2, 1, 2, new Date(), 2,
                8, 100, "[A1,A2,A3,A4,A5]");
        int res = repository.update(order);
        Assert.assertNotEquals(0, res);
    }*/

    @Test
    public void findById() {
        Order order = repository.findById(1);
        Assert.assertNotNull(order);
    }

    @Test
    public void findAll() {
        List<Order> orders = repository.findAll();
        Assert.assertNotNull(orders);
    }
}