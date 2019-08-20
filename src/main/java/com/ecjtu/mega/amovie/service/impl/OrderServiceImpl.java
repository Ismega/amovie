package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Order;
import com.ecjtu.mega.amovie.repository.OrderRepository;
import com.ecjtu.mega.amovie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public int save(Order order) {
        return repository.add(order);
    }

    @Override
    public Order findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public int update(Order order) {
        return repository.update(order);
    }
}
