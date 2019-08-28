package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.form.UserForm;
import com.ecjtu.mega.amovie.service.NewService;
import com.ecjtu.mega.amovie.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mega
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private NewService newService;

    @RequestMapping("/")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(value = "size", required = false, defaultValue = "3") Integer size,
                        Model model) {
        Page<News> newsList = PageHelper.startPage(page, size).doSelectPage(() -> newService.showAll());
        model.addAttribute("newsList", newsList);
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                HttpSession session) {
        User user = service.login(email, password);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            session.setAttribute("user", user);
            map.put("message", "登录成功");
            return ResponseEntity.ok(map);
        } else {
            map.put("message", "用户名或密码错误");
            return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity register(@RequestBody @Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity("用户信息不完全", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        boolean result = service.register(user);
        Map<String, Object> map = new HashMap<>();
        if (result) {
            map.put("message", "注册成功");
            return ResponseEntity.ok(map);
        } else {
            map.put("message", "注册失败");
            return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
