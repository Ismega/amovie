package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.entity.Watch;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.WatchService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author mega
 * @date 2019-08-28 14:38
 */
@Controller
@RequestMapping("/watch")
public class WatchController {

    @Autowired
    private WatchService service;

    /**
     * 获取所有观看电影列表
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/all")
    public String getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                         Model model) {
        Page<Watch> watchList = PageHelper.startPage(page, size).doSelectPage(() -> service.findAll());
        model.addAttribute("watchList", watchList);
        return "watchlist";
    }



}
