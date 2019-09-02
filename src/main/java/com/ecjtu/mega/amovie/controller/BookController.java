package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.Status;
import com.ecjtu.mega.amovie.entity.*;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.OrderService;
import com.ecjtu.mega.amovie.service.SceneService;
import com.ecjtu.mega.amovie.vo.OrderVo;
import com.ecjtu.mega.amovie.vo.TicketVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author mega
 * @date 2019-08-29 10:16
 */
@Controller
public class BookController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private SceneService sceneService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/book1/{movieId}")
    public String getBook1(@PathVariable(value = "movieId") Integer movieId,
                           Model model) {
        Movie movie = movieService.findById(movieId);
        if (movie != null) {
            List<Scene> sceneList = sceneService.findByMovieId(movieId);
            if (sceneList != null) {
                model.addAttribute("sceneList", sceneList);
                model.addAttribute("movie", movie);
                return "book1";
            }
        }
        return "404";
    }

    @RequestMapping(value = "/bookTicket2", method = RequestMethod.GET)
    public String getBook2(@RequestParam(value = "choosen-movie") Integer movieId,
                           @RequestParam(value = "choosen-scene") Integer sceneId,
                           Model model) {
        Rate rate = movieService.findMovieAndAvgScoreByMovieId(movieId);
        if (rate != null) {
            Scene scene = sceneService.findById(sceneId);
            if (scene != null) {
                model.addAttribute("scene", scene);
                model.addAttribute("rate", rate);
                return "book2";
            }
        }
        return "404";
    }

    @RequestMapping(value = "/bookTicket3", method = RequestMethod.GET)
    public String getBook3(TicketVo ticketVo,
                           Model model) {
        if (ticketVo != null) {
            model.addAttribute("ticketVo", ticketVo);
            return "book3-buy";
        }
        return "404";
    }

    //localhost:8080/bookFinal?sceneId=12&ticketNum=2&totalPrice=22&seat=L11,%20L10
//    ?sceneId={sceneId}&ticketNum={ticketNum}&totalPrice={totalPrice}&seat={seat}
    @GetMapping(value = "/bookFinal")
    public String purchase(Model model, HttpSession session,
                           @RequestParam("sceneId") Integer sceneId,
                           @RequestParam("ticketNum") Integer ticketNum,
                           @RequestParam("seat") String seat,
                           @RequestParam("totalPrice") Integer totalPrice) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Order order = new Order();
            order.setSceneId(sceneId);
            order.setTotalPrice(totalPrice);
            order.setTicketNum(ticketNum);
            order.setSeat(seat);
            order.setUserId(user.getId());
            order.setStatus(Status.ON);
            order.setCreateTime(new Date());
            int result = orderService.save(order);
            if (result > 0) {
                model.addAttribute("order", order);
                return "book-final";

            }
        }
        return "404";
    }

}
