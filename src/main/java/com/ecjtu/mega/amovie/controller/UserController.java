package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mega
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam(value = "status", defaultValue = "off") String status,
                                HttpServletResponse response,
                                HttpSession session) {
        User user = service.login(email, password);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            session.setAttribute("user", user);
            if ("on".equals(status)) {
                response.addCookie(new Cookie("email", email));
            }
            map.put("message", "登录成功");
            return ResponseEntity.ok(map);
        } else {
            map.put("message", "用户名或密码错误");
            return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(User user) {
        boolean result = service.register(user);
        if (result) {
            return "index";
        }
        return "404";
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
