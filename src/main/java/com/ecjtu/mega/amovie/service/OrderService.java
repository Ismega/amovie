package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Order;

import java.util.List;

public interface OrderService {

    //查询所有订单信息
    List<Order> findAll();

    //删除订单信息
    int delete(Integer id);

    //保存订单信息
    int save(Order order);

    //根据id查询订单信息
    Order findById(Integer id);

    //修改订单信息
    int update(Order order);


}
