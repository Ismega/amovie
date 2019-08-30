package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.*;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.ReviewService;
import com.ecjtu.mega.amovie.service.SceneService;
import com.ecjtu.mega.amovie.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author mega
 */
@Controller
@RequestMapping("/movies")
@Transactional
public class MovieController {

    @Autowired
    private MovieService service;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    @Autowired
    private SceneService sceneService;

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
            int count = reviewService.findCount(movie.getId());
            if (reviews != null) {
                for (Review review : reviews) {
                    User user = userService.findById(review.getUserId());
                    if (user != null) {
                        review.setNickname(user.getNickname());
                    }
                }
                model.addAttribute("count", count);
            }
            List<Scene> sceneList = sceneService.findByMovieId(id);
            if (sceneList != null) {
                model.addAttribute("sceneList", sceneList);
            }
            model.addAttribute("reviewList", reviews);
            model.addAttribute("movie", movie);
            return "movie";
        }
        return null;
    }

    @GetMapping("/rate")
    public String showRate(Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(value = "size", required = false, defaultValue = "5") Integer size) {
        PageInfo<Rate> movieAndAvgScore = PageHelper.startPage(page, size).doSelectPageInfo(() -> service.findMovieAndAvgScore());
        model.addAttribute("movieAndAvgScore", movieAndAvgScore);
        return "rate";

    }

    /**
     * 新增电影
     *
     * @param movieForm
     * @return
     */
/*    @PostMapping
    public ResponseEntity insert(@RequestBody MovieForm movieForm) {

        //MovieForm对象
        Integer[] categoryIds = movieForm.getCategoryIds();
        if (categoryIds != null) {
            Movie movie = new Movie();
            movie.setName(movieForm.getName());
            BeanUtils.copyProperties(movieForm, movie);
            int result = categoryService.insertRelation(movie, categoryIds);
            if (result != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
        }
        throw new CommonException("增加失败");
    }*/

    /**
     * 修改电影信息
     *
     * @param id
     * @param movieForm
     * @return
     */
/*    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody MovieForm movieForm) {
        Movie movie1 = service.findById(id);
        if (movie1 != null) {
            Integer[] categoryIds = movieForm.getCategoryIds();
            if (categoryIds != null) {
                Movie movie = new Movie();
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
    }*/

    /**
     * 删除电影信息
     *
     * @param id
     * @return
     */
  /*  @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            int res = categoryService.deleteRelation(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
        }
        throw new NotFoundException("资源未找到");
    }*/

    /**
     * 根据类型id查询电影
     *
     * @param id
     * @return
     */
  /*  @GetMapping("/category/{id}")
    public ResponseEntity findByCategoryId(@PathVariable(value = "id") Integer id) {
        List<Movie> movies = service.findByCategoryId(id);
        if (movies != null) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new NotFoundException("查询失败");
    }*/
}
