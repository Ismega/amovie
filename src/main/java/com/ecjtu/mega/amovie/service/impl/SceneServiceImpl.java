package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.Scene;
import com.ecjtu.mega.amovie.repository.SceneRepository;
import com.ecjtu.mega.amovie.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author mega
 */
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneRepository repository;

    @Override
    public List<Scene> findAll() {
        return repository.findAll();
    }

    @Override
    public Scene findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public int delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public int update(Scene scene) {
        scene.setSeatNum(166 - scene.getSeatNum());
//        Date t = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//        scene.setShowtime( df.format(t));
        return repository.update(scene);
    }

    @Override
    public int save(Scene scene) {
        scene.setSeatNum(166 - scene.getSeatNum());
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        scene.setShowtime(df.format(t));
        return repository.save(scene);
    }

    @Override
    public List<Scene> findByMovieId(Integer movieId) {
        return repository.findByMovieId(movieId);
    }
}
