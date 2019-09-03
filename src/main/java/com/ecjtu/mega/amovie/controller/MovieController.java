package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Rate;
import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.entity.Scene;
import com.ecjtu.mega.amovie.entity.User;
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

        /*Page<Movie> movies = PageHelper.startPage(page, size).
                doSelectPage(() -> service.showAll());//查询电影和类别*/
        Page<Rate> movies = PageHelper.startPage(page, size).
                doSelectPage(() -> service.findMovieAndAvgScore());//查询电影和类别和评分
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
//        Movie movie = service.findById(id);//查询电影和类型
        Rate movie = service.findMovieAndAvgScoreByMovieId(id);//查询电影和类型和评分
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
        return "404";
    }

    @GetMapping("/rate")
    public String showRate(Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(value = "size", required = false, defaultValue = "5") Integer size) {
        PageInfo<Rate> movieAndAvgScore = PageHelper.startPage(page, size).doSelectPageInfo(() ->
                service.findMovieAndAvgScoreSort());
        model.addAttribute("movieAndAvgScore", movieAndAvgScore);
        return "rate";
    }
}
