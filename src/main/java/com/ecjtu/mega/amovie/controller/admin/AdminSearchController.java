package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mega
 * @date 2019-08-29 16:09
 */
@RestController
public class AdminSearchController {

    @Autowired
    private MovieService service;

    @PostMapping(value = "/byMovieName/{searchContent}")
    public ResponseEntity searchBymovieName(@PathVariable(value = "searchContent") String searchContent) {
        List<Movie> movies = service.findByMovieName(searchContent);
        if (movies != null) {
            return new ResponseEntity(movies, HttpStatus.OK);
        }
        throw new NotFoundException("查询失败");
    }

}
