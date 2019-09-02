package com.ecjtu.mega.amovie.service;

import com.ecjtu.mega.amovie.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mega
 */
public interface OrderService {

    /**
     * 查询所有订单信息
     *
     * @return
     */
    List<Order> findAll();

    /**
     * 删除订单信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 保存订单信息
     *
     * @param order
     * @return
     */
    int save(Order order);

    /**
     * 根据id查询订单信息
     *
     * @param id
     * @return
     */
    Order findById(Integer id);

    /**
     * 修改订单信息
     *
     * @param order
     * @return
     */
    int update(Order order);

    Order findByBookedSeat(String bookedSeat);


}
