package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.form.MovieForm;
import com.ecjtu.mega.amovie.service.CategoryService;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.ReviewService;
import com.ecjtu.mega.amovie.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mega
 */
@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    /**
     * 获取电影列表
     * ram page
     *
     * @param size
     * @return
     */
    @GetMapping
    public String getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
                         Model model) {

        Page<Movie> movies = PageHelper.startPage(page, size).doSelectPage(() -> service.showAll());
        model.addAttribute("movieList", movies);
        return "movie-list";
    }

    /**
     * 根据id 查询电影
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable(value = "id") Integer id,
                          Model model) {
        Movie movie = service.findById(id);
        if (movie != null) {
            List<Review> reviews = reviewService.findByMovieId(movie.getId());
            if (reviews != null) {
                for (Review review : reviews) {
                    User user = userService.findById(review.getUserId());
                    if (user != null) {
                        review.setNickname(user.getNickname());
                    }
                }
                model.addAttribute("reviewList", reviews);
                model.addAttribute("movie", movie);
                return "movie";
            }

        }
        return null;
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
        Integer[] categoryIds = movieForm.getCategoryIds();
        if (categoryIds != null) {
            Movie movie = new Movie();
            movie.setName(movieForm.getName());
            //MovieForm转换成Movie对象了
            BeanUtils.copyProperties(movieForm, movie);
            int result = categoryService.insertRelation(movie, categoryIds);
            if (result != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
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
            Integer[] categoryIds = movieForm.getCategoryIds();
            if (categoryIds != null) {
                Movie movie = new Movie();
                //MovieForm转换成Movie对象了
                BeanUtils.copyProperties(movieForm, movie);
                movie.setId(id);
                int result = categoryService.updateRelation(movie, categoryIds);
                if (result != 0) {
                    return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
                }
                return ResponseEntity.badRequest().build();
            }
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
            int res = categoryService.deleteRelation(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 根据类型id查询电影
     *
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public ResponseEntity findByCategoryId(@PathVariable(value = "id") Integer id) {
        List<Movie> movies = service.findByCategoryId(id);
        if (movies != null) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new NotFoundException("查询失败");
    }
}
