package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.repository.MovieRepository;
import com.ecjtu.mega.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    /**
     * 查询所有电影信息
     *
     * @return
     */
    @Override
    public List<Movie> showAll() {
        return repository.findAll();
    }

    /**
     * 根据名字查询电影信息
     *
     * @param name
     * @return
     */
    @Override
    public Movie findByName(String name) {
        return repository.findByMovieName(name);
    }

    /**
     * 添加电影信息
     *
     * @param movie
     * @return
     */
    @Override
    public int save(Movie movie) {
        return repository.save(movie);
    }

    /**
     * 修改电影信息
     *
     * @param movie
     * @return
     */
    @Override
    public int update(Movie movie) {
        return repository.update(movie);
    }

    /**
     * 根据id删除电影信息
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }
}
