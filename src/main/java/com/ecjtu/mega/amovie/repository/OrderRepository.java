package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mega
 */
@Mapper
@Repository
public interface OrderRepository {

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @Insert("insert into `order` (status,user_id,create_time,scene_id,ticket_num,total_price,seat) " +
            "values(#{status},#{userId},#{createTime},#{sceneId},#{ticketNum},#{totalPrice},#{seat}) ")
    int add(Order order);

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    int update(Order order);

    /**
     * 根据id 查询订单
     *
     * @param id
     * @return
     */
    @Select("select * from `order` where id=#{id}")
    Order findById(Integer id);

    /**
     * 查询所有订单
     *
     * @return
     */
    @Select("select * from `order`")
    List<Order> findAll();

    /**
     * 根据订单id删除订单
     *
     * @param id
     * @return
     */
    @Delete("delete from `order` where id=#{id}")
    int delete(Integer id);

}
