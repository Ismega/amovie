package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Order;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mega
 * @date 2019-08-26 18:51
 */
@RestController
@CrossOrigin
@RequestMapping("/orders")
public class AdminOrderController {

    @Autowired
    private OrderService service;

    /**
     * 获取订单列表 分页
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {
        Page<Order> orders = PageHelper.startPage(page, size).doSelectPage(() -> service.findAll());
        return new ResponseEntity(orders.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        List<Order> orders = service.findAll();
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    /**
     * 根据id 查询订单
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", params = "id")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Order order = service.findById(id);
        if (order != null) {
            return new ResponseEntity(order, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 新增订单
     *
     * @param order
     * @return
     */
    @Transactional
    @PostMapping
    public ResponseEntity insert(Order order) {
        int result = service.save(order);
        if (result != 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("增加失败");
    }

    /**
     * 修改订单
     *
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody Order order) {
        Order order1 = service.findById(id);
        if (order1 != null) {
            order.setId(id);
            int res = service.update(order);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("修改失败");
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 删除订单信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Order order = service.findById(id);
        if (order != null) {
            int res = service.delete(id);
            if (res != 0) {
                return new ResponseEntity("删除成功", HttpStatus.OK);
            }
            throw new CommonException("删除失败");
        }
        throw new NotFoundException("资源未找到");
    }

}
