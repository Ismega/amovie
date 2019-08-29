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
}
