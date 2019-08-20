package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Category;
import com.ecjtu.mega.amovie.repository.CategoryRepository;
import com.ecjtu.mega.amovie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public int save(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id);
    }

    @Override
    public int delete(String id) {
        return repository.delete(id);
    }
}
