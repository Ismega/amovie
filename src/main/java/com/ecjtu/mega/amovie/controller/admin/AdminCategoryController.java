package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Category;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author mega
 */
@RestController
@RequestMapping("/api/categories")
@CrossOrigin
/**
 * 类别
 */
public class AdminCategoryController {

    @Autowired
    private CategoryService service;

    /**
     * 获取类别列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity getCategory(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {
        Page<Category> categories = PageHelper.startPage(page, size).doSelectPage(() -> service.findAll());
        return new ResponseEntity(categories.toPageInfo(), HttpStatus.OK);
    }

    /**
     * 获取所有类别，不分页
     *
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity getAll() {
        List<Category> categories = service.findAll();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    /**
     * 获取类别
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable(value = "id") Integer id) {
        Category category = service.findById(id);
        if (category != null) {
            return new ResponseEntity(category, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 创建类别
     *
     * @param category
     * @return
     */
    @PostMapping
    public ResponseEntity insert(@RequestBody Category category) {
        int result = service.save(category);
        if (result != 0) {
            return ResponseEntity.ok(CommonCode.success());
        }

        throw new CommonException("创建失败");
    }

    /**
     * 修改类别
     *
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody Category category) {
        Category result = service.findById(id);
        if (result != null) {
            category.setId(id);
            int res = service.update(category);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("修改失败");
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 删除类别
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Category category = service.findById(id);
        if (category != null) {
            int res = service.delete(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("删除失败");
        }
        throw new NotFoundException("资源未找到");
    }
}
