package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Score;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.form.ScoreForm;
import com.ecjtu.mega.amovie.service.RateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author mega
 * @date 2019-08-30 16:15
 */
@RestController
@RequestMapping("/api/rate")
public class AdminRateController {

    @Autowired
    private RateService service;

    @PostMapping
    public ResponseEntity rate(@RequestBody @Valid ScoreForm scoreForm, BindingResult bindingResult,
                               HttpSession session) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity("请输入完整电影信息！", HttpStatus.BAD_REQUEST);
        }
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Score score = new Score();
            BeanUtils.copyProperties(scoreForm, score);
            score.setUserId(user.getId());
            Score score1 = service.findByUserIdAndMovieId(user.getId(), scoreForm.getMovieId());
            if (score1 == null) {
                int result = service.insert(score);
                if (result != 0) {
                    return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
                }
            } else {
                return new ResponseEntity(CommonCode.error("您已评过分！"), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity("请先登录！", HttpStatus.NOT_FOUND);
    }
}
