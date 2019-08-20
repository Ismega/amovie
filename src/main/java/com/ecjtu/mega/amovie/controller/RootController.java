package com.ecjtu.mega.amovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/404.html")
    public String error() {
        return "404";
    }

    @RequestMapping("/new.html")
    public String news() {
        return "new";
    }

    @RequestMapping("/rate.html")
    public String rate() {
        return "rate";
    }

    @RequestMapping("/ticket.html")
    public String ticket() {
        return "ticket";
    }
}
