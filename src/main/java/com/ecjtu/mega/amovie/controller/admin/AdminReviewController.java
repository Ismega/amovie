package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Review;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.form.ReviewForm;
import com.ecjtu.mega.amovie.service.ReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author mega
 */
@RestController
@CrossOrigin
@RequestMapping("/api/reviews")
public class AdminReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping
    public ResponseEntity getAll() {
        List<Review> reviewList = service.getAll();
        return new ResponseEntity(reviewList, HttpStatus.OK);
    }

/*    @GetMapping("/{movieId}")
    public String findByMovieId(@PathVariable(value = "movieId") Integer movieId,
                                Model model) {
        List<Review> reviews = service.findByMovieId(movieId);
        if (reviews!= null) {
            model.addAttribute("reviews",reviews);
            return "movie";
        }
        return null;
    }*/

    /**
     * 发表评论
     *
     * @param reviewForm
     * @return
     */
    @PostMapping
    public ResponseEntity add(@RequestBody @Valid ReviewForm reviewForm) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewForm, review);
        review.setCreateTime(new Date());
        int res = service.publish(review);
        if (res > 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("增加失败");
    }
}
