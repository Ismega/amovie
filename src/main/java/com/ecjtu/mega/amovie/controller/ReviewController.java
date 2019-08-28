package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.form.ReviewForm;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author mega
 */
@Controller
@RequestMapping("/reviewList")
/**
 * 影评
 */
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping
    public String getAll(Model model) {
        List<Review> reviews = service.getAll();
        model.addAttribute("reviews", reviews);
        return "movie";
    }

    /**
     * 添加影评
     *
     * @param reviewForm
     * @return
     */
    @PostMapping
    public String add(@RequestBody @Valid ReviewForm reviewForm) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewForm, review);
        review.setCreateTime(new Date());
        int res = service.publish(review);
        if (res > 0) {
            return "movie";
        }
        return null;
    }

    @GetMapping("/{movieId}")
    public String findByMovieId(@PathVariable(value = "movieId") Integer movieId,
                                Model model) {
        List<Review> reviews = service.findByMovieId(movieId);
        if (reviews != null) {
            model.addAttribute("reviews", reviews);
            return "movie";
        }
        return null;
    }
}
