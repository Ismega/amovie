package com.ecjtu.mega.amovie.service.impl;

import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.service.NewService;
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
public class NewServiceImplTest {

    @Autowired
    private NewService service;

    @Test
    public void showAll() {
        List<News> news = service.showAll();
        Assert.assertNotNull(news);
    }

    @Test
    public void delete() {
        int res = service.delete(2);
        Assert.assertEquals(1, res);
    }

    @Test
    public void update() {
        News news = new News(2, "8月17日零点刚过，燃爆2019的国漫代表作《哪吒之魔童降世》票房正式突破40亿大关！该片也成为了中国影史第四部票房超40亿的作品。\n" +
                "据猫眼专业版数据预测，《哪吒》的最终票房将达到46.84亿。如能实现，《哪吒》超过《复仇者联盟4：终局之战》（42.4亿）跻身中国影史票房前三甲指日可待。",
                new Date());
        int res = service.update(news);
        Assert.assertEquals(1, res);
    }

    @Test
    public void save() {
        News news = new News("7月18日零点刚过，燃爆2019的国漫代表作《哪吒之魔童降世》票房正式突破40亿大关！该片也成为了中国影史第四部票房超40亿的作品。\n" +
                "据猫眼专业版数据预测，《哪吒》的最终票房将达到46.84亿。如能实现，《哪吒》超过《复仇者联盟4：终局之战》（42.4亿）跻身中国影史票房前三甲指日可待。",
                new Date());
        int res = service.save(news);
        Assert.assertEquals(1, res);
    }
}