package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author mega
 */
@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @RequestMapping
    public String add(@RequestParam(value = "movieId") Integer movieId,
                      @RequestParam(value = "userId") Integer userId,
                      @RequestParam(value = "content") String content) {
        Review review = new Review();
        review.setContent(content);
        review.setMovieId(movieId);
        review.setUserId(userId);
        review.setCreateTime(new Date());
        service.publish(review);
        return "movie";
    }
}
