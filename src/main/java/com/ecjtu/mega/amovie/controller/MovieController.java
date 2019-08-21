package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.form.MovieForm;
import com.ecjtu.mega.amovie.service.MovieService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    /**
     * 获取电影列表
     * ram page
     *
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "4") Integer size) {

        Page<Movie> movies = PageHelper.startPage(page, size).doSelectPage(() -> service.showAll());
        return new ResponseEntity(movies, HttpStatus.OK);
    }

    /**
     * 根据id 查询电影
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            return new ResponseEntity(movie, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 新增电影
     *
     * @param movieForm
     * @return
     */
    @PostMapping
    public ResponseEntity insert(@RequestBody MovieForm movieForm) {

        //MovieForm对象
        Integer[] ids = movieForm.getCategoryIds();
//        System.out.println(Arrays.toString(ids));
        StringBuilder sb = new StringBuilder();
        for (Integer str : ids) {
            sb.append(str);
            sb.append(",");
        }
        String string = sb.toString();
        string = string.substring(0, string.length() - 1);
        Movie movie = new Movie();
        //MovieForm转换成Movie对象了
        BeanUtils.copyProperties(movieForm, movie);
        movie.setCategoryId(string);
        int result = service.save(movie);
        if (result != 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("增加失败");
    }

    /**
     * 修改电影信息
     *
     * @param id
     * @param movieForm
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody MovieForm movieForm) {
        Movie movie1 = service.findById(id);
        if (movie1 != null) {
            Integer[] ids = movieForm.getCategoryIds();
            StringBuilder sb = new StringBuilder();
            for (Integer str : ids) {
                sb.append(str);
                sb.append(",");
            }
            String string = sb.toString();
            string = string.substring(0, string.length() - 1);
            Movie movie = new Movie();
            BeanUtils.copyProperties(movieForm, movie);
            movie.setCategoryId(string);
            int res = service.update(movie);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("修改失败");
        }
        throw new NotFoundException("资源未找到");


    }

    /**
     * 删除电影信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            int res = service.delete(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("删除失败");
        }
        throw new NotFoundException("资源未找到");
    }
}
