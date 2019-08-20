package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderRepository {

    //添加订单
    @Insert("insert into `order` (status,user_id,create_time,scene_id,ticket_num,total_price,seat) " +
            "values(#{status},#{userId},#{createTime},#{sceneId},#{ticketNum},#{totalPrice},#{seat}) ")
    int add(Order order);

    //修改订单
    @Update("update `order` set status=#{status},scene_id=#{sceneId},ticket_num=#{ticketNum},total_price=#{totalPrice},seat=#{seat}")
    int update(Order order);

    //根据id 查询订单
    @Select("select * from `order` where id=#{id}")
    Order findById(Integer id);

    //查询所有订单
    @Select("select * from `order`")
    List<Order> findAll();

    @Delete("delete from `order` where id=#{id}")
    int delete(Integer id);

}
