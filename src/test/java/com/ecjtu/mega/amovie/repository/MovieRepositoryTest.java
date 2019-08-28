package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    public void findAll() {
        List<Movie> movies = repository.findAll();
        System.out.println(movies);

    }

    @Test
    public void findByMovieName() {
        List<Movie> movie = repository.findByMovieName("哪吒");
        System.out.println(movie);
    }

    @Test
    public void update() {
        Movie movie = new Movie(2, "哪吒之魔童降世", "2019", "肖莉岚", "吕艳婷,囧森瑟夫, 瀚墨 , 陈浩 ,绿绮", new Date(), 0,
                "天地灵气孕育出一颗能量巨大的混元珠，元始天尊将混元珠提炼成灵珠和魔丸，灵珠投胎为人，助周伐纣时可堪大用；而魔丸则会诞出魔王，为祸人间。元始天尊启动了天劫咒语，3年后天雷将会降临，摧毁魔丸。" +
                        "太乙受命将灵珠托生于陈塘关李靖家的儿子哪吒身上。然而阴差阳错，灵珠和魔丸竟然被掉包。本应是灵珠英雄的哪吒却成了混世大魔王。调皮捣蛋顽劣不堪的哪吒却徒有一颗做英雄的心。" +
                        "然而面对众人对魔丸的误解和即将来临的天雷的降临，哪吒是否命中注定会立地成魔？他将何去何从？",
                "中国大陆");
        int result = repository.update(movie);
        Assert.assertEquals(1, result);
    }

    @Test
    public void delete() {
        int result = repository.delete(3);
        Assert.assertEquals(1, result);
    }

    @Test
    public void save() {
        Movie movie = new Movie("哪吒之魔童降世3", "2019", "肖莉岚", "吕艳婷,囧森瑟夫, 瀚墨 , 陈浩 ,绿绮", new Date(), 0,
                "天地灵气孕育出一颗能量巨大的混元珠，元始天尊将混元珠提炼成灵珠和魔丸，灵珠投胎为人，助周伐纣时可堪大用；而魔丸则会诞出魔王，为祸人间。元始天尊启动了天劫咒语，3年后天雷将会降临，摧毁魔丸。" +
                        "太乙受命将灵珠托生于陈塘关李靖家的儿子哪吒身上。然而阴差阳错，灵珠和魔丸竟然被掉包。本应是灵珠英雄的哪吒却成了混世大魔王。调皮捣蛋顽劣不堪的哪吒却徒有一颗做英雄的心。" +
                        "然而面对众人对魔丸的误解和即将来临的天雷的降临，哪吒是否命中注定会立地成魔？他将何去何从？",
                "中国大陆");
        int result = repository.save(movie);
        Assert.assertEquals(1, result);

    }

    @Test
    public void findById() {
        Movie movie = repository.findById(1);
        Assert.assertNotNull(movie);
    }

    @Test
    public void findByCategoryId() {
        List<Movie> movieList = repository.findByCategoryId(10);
        System.out.println(movieList);
    }


}