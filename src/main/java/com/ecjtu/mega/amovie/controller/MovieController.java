package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService service;

    @RequestMapping("/movie")
    public ModelAndView getAll() {
        List<Movie> movies = service.showAll();
        ModelAndView modelAndView = null;
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

}
