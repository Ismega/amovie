package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.NewService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author mega
 */
@Controller
@RequestMapping("/newsList")
/**
 * 资讯
 */
public class NewsController {

    @Autowired
    private NewService service;

    /**
     * 获取所有资讯内容  分页
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping()
    public String getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                         @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                         Model model) {
        PageInfo<News> newsPage = PageHelper.startPage(page, size).doSelectPageInfo(() -> service.showAll());
        model.addAttribute("newsPage", newsPage);
        return "news-list";
    }

    /**
     * 根据id 查询资讯
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable(value = "id") Integer id) {
        News news = service.findById(id);
        if (news != null) {
            return new ResponseEntity(news, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }
}
