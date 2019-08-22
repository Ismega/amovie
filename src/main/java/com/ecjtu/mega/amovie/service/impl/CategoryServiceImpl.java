package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Category;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.repository.CategoryRepository;
import com.ecjtu.mega.amovie.repository.MovieRepository;
import com.ecjtu.mega.amovie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mega
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public int save(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public int update(Category category) {
        return repository.update(category);
    }

    /**
     * 插入电影类型和电影id
     *
     * @param movie
     * @param categoryIds
     * @return
     */
    @Override
    public int insertRelation(Movie movie, Integer[] categoryIds) {
        int result = movieRepository.save(movie);
        if (result != 0) {
            for (Integer categoryId : categoryIds) {
                repository.insertRelation(movie.getId(), categoryId);
            }
        }
        return 0;
    }

    @Override
    public int updateRelation(Movie movie, Integer[] categoryIds) {
        int result = movieRepository.update(movie);
        if (result != 0) {
            for (Integer categoryId : categoryIds) {
                repository.updateRelation(categoryId);
            }
        }
        return 0;
    }

    @Override
    public int deleteRelation(Integer movieId) {
        int res = movieRepository.delete(movieId);
        if (res != 0) {
            return repository.deleteRelation(movieId);
        }
        return 0;

    }
}
