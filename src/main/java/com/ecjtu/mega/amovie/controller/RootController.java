package com.ecjtu.mega.amovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mega
 */
@Controller
public class RootController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/404")
    public String error() {
        return "404";
    }

    @RequestMapping("/news")
    public String news() {
        return "news";
    }

    @RequestMapping("/rate")
    public String rate() {
        return "rate";
    }

    @RequestMapping("/ticket")
    public String ticket() {
        return "ticket";
    }

    @RequestMapping("/book1")
    public String book1() {
        return "book1";
    }

    @RequestMapping("/book2")
    public String book2() {
        return "book2";
    }

    @RequestMapping("/book3")
    public String book3() {
        return "book3-buy";
    }

    @RequestMapping("/book-final")
    public String bookfinal() {
        return "book-final";
    }

    @RequestMapping("/movie")
    public String movie() {
        return "movie";
    }

    @RequestMapping("/watchlist")
    public String watchlist() {
        return "watchlist";
    }

    @RequestMapping("/search")
    public String search() {
        return "search";
    }


}
