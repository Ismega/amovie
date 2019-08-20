package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService service;

    @RequestMapping("/review")
    public String review(@RequestParam(value = "movieId") Integer movieId,
                         @RequestParam(value = "userId") Integer userId,
                         @RequestParam(value = "content") String content) {
        Review review = new Review();
        review.setContent(content);
        review.setMovieId(movieId);
        review.setUserId(userId);
        service.publish(review);
        return "redirect:/";
    }
}
