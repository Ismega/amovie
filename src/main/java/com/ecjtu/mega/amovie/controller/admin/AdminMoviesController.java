package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.constant.Status;
import com.ecjtu.mega.amovie.entity.Movie;
import com.ecjtu.mega.amovie.entity.Rate;
import com.ecjtu.mega.amovie.exception.CommonException;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.form.MovieForm;
import com.ecjtu.mega.amovie.service.CategoryService;
import com.ecjtu.mega.amovie.service.MovieService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author mega
 */
@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class AdminMoviesController {

    @Autowired
    private MovieService service;
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取电影列表
     * ram page
     *
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                                 HttpSession session) {

        Page<Movie> movies = PageHelper.startPage(page, size).doSelectPage(() -> service.showAll());
        session.setAttribute("movieList", movies);
        return new ResponseEntity(movies.toPageInfo(), HttpStatus.OK);
    }

    /**
     * 获取所有电影信息，不分页
     *
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity getAll() {
        List<Movie> movieList = service.showAll();
        return new ResponseEntity(movieList, HttpStatus.OK);
    }


    /**
     * 根据id 查询电影
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", params = "id")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            return new ResponseEntity(movie, HttpStatus.OK);
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 新增电影
     *
     * @param movieForm
     * @return
     */
    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid MovieForm movieForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldError().getDefaultMessage();
            return new ResponseEntity("请输入完整电影信息！", HttpStatus.BAD_REQUEST);
        }
        //MovieForm对象
        Integer[] categoryIds = movieForm.getCategoryIds();
        if (categoryIds != null) {
            Movie movie = new Movie();
            BeanUtils.copyProperties(movieForm, movie);

            System.out.println(movie.getReleaseTime());

            int result = categoryService.insertRelation(movie, categoryIds);
            if (result != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
        }
        throw new CommonException("增加失败");
    }


    /**
     * 删除电影信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            int res = categoryService.deleteRelation(id);
            if (res != 0) {
                return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
            }
        }
        throw new NotFoundException("资源未找到");
    }

    /**
     * 根据类型id查询电影
     *
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public ResponseEntity findByCategoryId(@PathVariable(value = "id") Integer id) {
        List<Movie> movies = service.findByCategoryId(id);
        if (movies != null) {
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        }
        throw new NotFoundException("查询失败");
    }

    /**
     * 根据电影已上映状态查询电影
     *
     * @return
     */
    @GetMapping("/released")
    public ResponseEntity findByReleased() {
        List<Rate> movies = service.findByStatus(Status.ON);
        return new ResponseEntity(movies, HttpStatus.OK);
    }

}
