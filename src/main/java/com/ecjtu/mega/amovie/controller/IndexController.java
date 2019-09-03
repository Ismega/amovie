package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.Status;
import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.entity.Rate;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.NewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mega
 * @date 2019-09-01 00:42
 */
@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private NewService newService;

    @GetMapping("/")
    public String getAll(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "size", required = false, defaultValue = "6") Integer size) {
        PageInfo<Rate> rateList = PageHelper.startPage(page, size).doSelectPageInfo(() ->
                movieService.findMovieAndAvgScoreSort());
        PageInfo<Rate> movieList = PageHelper.startPage(1, 3).doSelectPageInfo(() ->
                movieService.findMovieAndAvgScore());

        PageInfo<News> newsList = PageHelper.startPage(1, 3).doSelectPageInfo(() -> newService.showAll());
        PageInfo<Rate> movieServiceByStatus = PageHelper.startPage(1, 8).doSelectPageInfo(() ->
                movieService.findByStatus(Status.ON));
        model.addAttribute("movieList", movieList);
        model.addAttribute("movieServiceByStatus", movieServiceByStatus);
        model.addAttribute("newsList", newsList);
        model.addAttribute("rateList", rateList);
        return "index";
    }

}
