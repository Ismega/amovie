package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Watch;
import com.ecjtu.mega.amovie.repository.WatchRepository;
import com.ecjtu.mega.amovie.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mega
 * @date 2019-08-28 11:58
 */
@Service
public class WatchServiceImpl implements WatchService {

    @Autowired
    private WatchRepository repository;

    @Override
    public int insert(Watch watch) {
        return repository.insert(watch);
    }

    @Override
    public List<Watch> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Watch> findByUserId(Integer userId) {
        return repository.findMovieByUserId(userId);
    }

    @Override
    public int deleteWatch(Integer movieId) {
        return repository.deleteWatch(movieId);
    }
}
