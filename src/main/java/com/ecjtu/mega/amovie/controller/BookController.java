package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Scene;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author mega
 * @date 2019-08-29 10:16
 */
@Controller
@RequestMapping
public class BookController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private SceneService sceneService;

    @GetMapping("/book1/{movieId}")
    public String getBook1(@PathVariable(value = "movieId") Integer movieId,
                           Model model) {
        Movie movie = movieService.findById(movieId);
        if (movie != null) {
            List<Scene> sceneList = sceneService.findByMovieId(movieId);
            for (Scene scene : sceneList) {
                System.out.println(scene.getMovieId());
            }
            if (sceneList != null) {
                model.addAttribute("sceneList", sceneList);
                model.addAttribute("movie", movie);
                return "book1";
            }
        }
        return "404";
    }
}
