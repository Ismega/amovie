package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Watch;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.form.WatchForm;
import com.ecjtu.mega.amovie.service.WatchService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author mega
 * @date 2019-08-28 12:01
 */
@RestController
@RequestMapping("/api/watch")
@CrossOrigin
public class AdminWatchController {
    @Autowired
    private WatchService service;

    /**
     * 添加至观看列表
     *
     * @param watchForm
     * @return
     */
    @PostMapping
    public ResponseEntity addWatch(@RequestBody @Valid WatchForm watchForm) {
        Watch watch = new Watch();
        BeanUtils.copyProperties(watchForm, watch);
        watch.setCreateTime(new Date());
        int res = service.insert(watch);
        if (res > 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("添加失败");
    }

    /**
     * 从观看列表移除
     *
     * @param movieId
     * @return
     */
    @DeleteMapping("/{movieId}")
    public ResponseEntity deleteWatch(@PathVariable(value = "movieId") Integer movieId) {
        int result = service.deleteWatch(movieId);
        if (result > 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("移除失败");
    }
}
