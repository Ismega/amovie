package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author mega
 * @date 2019-08-29 16:11
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private MovieService service;

    @GetMapping("/byMovieName/{searchContent}")
    public String getByName(@PathVariable(value = "searchContent") String searchContent,
                            Model model) {
        List<Movie> movies = service.findByMovieName(searchContent);
        if (movies != null) {
            model.addAttribute("movieList", movies);
            return "search";
        }
        return null;
    }

    @GetMapping("/byActor/{searchContent}")
    public String searchByActor(@PathVariable(value = "searchContent") String actor,
                                Model model) {
        List<Movie> movies = service.findByActor(actor);
        if (movies != null) {
            model.addAttribute("movieList", movies);
            return "search";
        }
        return null;
    }

    @GetMapping("/byDirector/{searchContent}")
    public String searchByDirector(@PathVariable(value = "searchContent") String director,
                                   Model model) {
        List<Movie> movies = service.findByDirector(director);
        if (movies != null) {
            model.addAttribute("movieList", movies);
            return "search";
        }
        return null;
    }

    @GetMapping("/byCategory/{searchContent}")
    public String searchByCategory(@PathVariable(value = "searchContent") String category,
                                   Model model) {
        List<Movie> movies = service.findByCategory(category);
        if (movies != null) {
            model.addAttribute("movieList", movies);
            return "search";
        }
        return null;
    }

    @GetMapping("/byCountry/{searchContent}")
    public String searchByCountry(@PathVariable(value = "searchContent") String country,
                                  Model model) {
        List<Movie> movies = service.findByCountry(country);
        if (movies != null) {
            model.addAttribute("movieList", movies);
            return "search";
        }
        return null;
    }
}
