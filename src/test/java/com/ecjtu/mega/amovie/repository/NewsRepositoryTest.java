package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.News;
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
public class NewsRepositoryTest {

    @Autowired
    private NewsRepository repository;

    @Test
    public void findAll() {
        List<News> news = repository.findAll();
        Assert.assertNotNull(news);
    }

    @Test
    public void findById() {
        News result = repository.findById(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void save() {
        News news = new News("7月18日零点刚过，燃爆2019的国漫代表作《哪吒之魔童降世》票房正式突破40亿大关！该片也成为了中国影史第四部票房超40亿的作品。\n" +
                "据猫眼专业版数据预测，《哪吒》的最终票房将达到46.84亿。如能实现，《哪吒》超过《复仇者联盟4：终局之战》（42.4亿）跻身中国影史票房前三甲指日可待。", new Date(), "dkdoif");
        int res = repository.save(news);
        Assert.assertEquals(1, res);
    }

    @Test
    public void update() {
        News news = new News(4, "6月17日零点刚过，燃爆2019的国漫代表作《哪吒之魔童降世》票房正式突破40亿大关！该片也成为了中国影史第四部票房超40亿的作品。\n" +
                "据猫眼专业版数据预测，《哪吒》的最终票房将达到46.84亿。如能实现，《哪吒》超过《复仇者联盟4：终局之战》（42.4亿）跻身中国影史票房前三甲指日可待。"
                , new Date(), "dkdoif");
        int res = repository.update(news);
        Assert.assertEquals(1, res);
    }

    @Test
    public void delete() {
        repository.delete(3);
    }
}