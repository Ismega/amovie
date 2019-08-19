package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.User;
import com.ecjtu.mega.amovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login/{email}/{password}")
    public String login(@PathVariable("email") String email,
                        @PathVariable("password") String password) {
        User user = service.login(email, password);
        if (user != null) {
            return "index";
        }
        return null;
    }

    @RequestMapping("/register")
    public String register(User user) {
        boolean result = service.register(user);
        if (result) {
            return "index";
        }
        return null;
    }
}
