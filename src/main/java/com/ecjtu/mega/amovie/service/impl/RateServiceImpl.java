package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Score;
import com.ecjtu.mega.amovie.repository.RateRepository;
import com.ecjtu.mega.amovie.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mega
 * @date 2019-08-29 09:26
 */
@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository repository;

    @Override
    public int insert(Score score) {
        return repository.insert(score);
    }
}
