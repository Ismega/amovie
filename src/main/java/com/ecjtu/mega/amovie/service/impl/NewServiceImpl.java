package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.repository.NewsRepository;
import com.ecjtu.mega.amovie.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewsRepository repository;

    @Override
    public List<News> showAll() {
        return repository.findAll();
    }

    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public int update(News news) {
        return repository.update(news);
    }

    @Override
    public int save(News news) {
        return repository.save(news);
    }
}
