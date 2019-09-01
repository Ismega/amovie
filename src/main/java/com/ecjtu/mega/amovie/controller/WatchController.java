package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Rate;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author mega
 * @date 2019-08-28 14:38
 */
@Controller
@RequestMapping("/watch")
public class WatchController {

    @Autowired
    private MovieService movieService;

    /**
     * 显示观看列表
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping
    public String Watch(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(value = "size", required = false, defaultValue = "3") Integer size,
                        Model model,
                        HttpSession session) {
        User user = (User) session.getAttribute("user");
        PageInfo<Rate> movieByUserIdList = PageHelper.startPage(page, size).
                doSelectPageInfo(() -> movieService.findMovieAndAvgScoreByUserId(user.getId()));
        if (movieByUserIdList != null) {
            model.addAttribute("movieByUserIdList", movieByUserIdList);
            return "watchlist";
        }
        return null;
    }
}
