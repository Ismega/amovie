package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Scene;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.SceneService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scenes")
public class SceneController {

    @Autowired
    private SceneService service;

    /**
     * 查询所有
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity findAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "4") Integer size) {
        Page<Scene> scenes = PageHelper.startPage(page, size).doSelectPage(() -> service.findAll());
        return new ResponseEntity(scenes.toPageInfo(), HttpStatus.OK);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Scene scene = service.findById(id);
        if (scene != null) {
            return new ResponseEntity(scene, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 插入数据
     *
     * @param scene
     * @return
     */
    @PostMapping
    public ResponseEntity insert(@RequestBody Scene scene) {
        int result = service.save(scene);
        if (result < 1) {
            throw new CommonException("插入失败");
        }
        return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
    }

    /**
     * 更新
     *
     * @param id
     * @param scene
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody Scene scene) {
        Scene scene1 = service.findById(id);
        if (scene1 != null) {
            scene.setId(id);
            int res = service.update(scene);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("更新失败");
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 删除场次信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Scene scene = service.findById(id);
        if (scene != null) {
            int res = service.delete(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("删除失败");
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 根据电影id查询场次数
     *
     * @param id
     * @return
     */
    @PostMapping("/movies/{id}/scenes")
    public ResponseEntity getSceneByMovieId(@PathVariable(value = "id") Integer id) {
        int count = service.findByMovieId(id);
        return new ResponseEntity(count, HttpStatus.OK);
    }
}