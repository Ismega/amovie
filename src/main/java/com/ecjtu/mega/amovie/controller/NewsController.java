package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.entity.News;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.service.NewService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        Page<News> newsPage = PageHelper.startPage(page, size).doSelectPage(() -> service.showAll());
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

    /**
     * 新增资讯
     *
     * @param news
     * @return
     */
   /* @PostMapping
    public ResponseEntity insert(@RequestBody News news) {
        int result = service.save(news);
        if (result != 0) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new CommonException("增加失败");
    }*/

    /**
     * 修改资讯
     *
     * @param id
     * @param news
     * @return
     */
   /* @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id,
                                 @RequestBody News news) {
        News news1 = service.findById(id);
        if (news1 != null) {
            news.setId(id);
            int res = service.update(news);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
            throw new CommonException("修改失败");
        }
        throw new NotFoundException("资源未找到");
    }*/

    /**
     * 删除资讯
     *
     * @param id
     * @return
     */
    /*@DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        News news = service.findById(id);
        if (news != null) {
            int res = service.delete(id);
            if (res != 0) {
                return new ResponseEntity("删除成功", HttpStatus.OK);
            }
            throw new CommonException("删除失败");
        }
        throw new NotFoundException("资源未找到");
    }*/
}
