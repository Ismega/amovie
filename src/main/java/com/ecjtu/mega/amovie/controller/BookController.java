package com.ecjtu.mega.amovie.controller;

import com.ecjtu.mega.amovie.constant.Status;
import com.ecjtu.mega.amovie.entity.*;
import com.ecjtu.mega.amovie.service.MovieService;
import com.ecjtu.mega.amovie.service.OrderService;
import com.ecjtu.mega.amovie.service.SceneService;
import com.ecjtu.mega.amovie.vo.TicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @GetMapping("/bookTicket/{userId}")
    public String getOrder(Model model,
                           @PathVariable("userId") Integer userId) {
        List<Order> byUserId = orderService.findByUserId(userId);
        if (byUserId != null) {
            for (Order order : byUserId) {
                Scene scene = sceneService.findById(order.getSceneId());
                order.setMovieName(scene.getMovieName());
                String uuid = UUID.randomUUID().toString();
                order.setUuid(uuid);
            }
            model.addAttribute("orderList", byUserId);
            return "ticket";
        }
        return "404";
    }

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
            String bookedSeat = scene.getBookedSeat();
            bookedSeat = bookedSeat.replaceAll(" ", "");
            String[] split = {};
            if (!StringUtils.isEmpty(bookedSeat)) {
                split = Arrays.stream(bookedSeat.split(","))
                        .map(s -> String.format("\"%s\"", s)).toArray(String[]::new);
            }
            if (scene != null) {
                model.addAttribute("scene", scene);
                model.addAttribute("rate", rate);
                model.addAttribute("bookedSeat", Arrays.toString(split));
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

    @GetMapping(value = "/bookFinal")
    public String purchase(Model model, HttpSession session,
                           @RequestParam("sceneId") Integer sceneId,
                           @RequestParam("ticketNum") Integer ticketNum,
                           @RequestParam("seat") String seat,
                           @RequestParam("totalPrice") Integer totalPrice,
                           @RequestParam("movieName") String movieName,
                           @RequestParam("price") Integer price,
                           @RequestParam("movieId") Integer movieId) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Scene sc = sceneService.findById(sceneId);
            StringBuilder append = new StringBuilder().append(seat).append(",").append(sc.getBookedSeat());
            Scene scene = new Scene();
            scene.setId(sceneId);
            scene.setBookedSeat(append.toString());
            int update = sceneService.update(scene);
            Order order = new Order();
            order.setSceneId(sceneId);
            order.setTotalPrice(totalPrice);
            order.setTicketNum(ticketNum);
            order.setSeat(seat);
            order.setUserId(user.getId());
            order.setStatus(Status.ON);
            order.setCreateTime(new Date());
            int result = orderService.save(order);
            if (result > 0 && update > 0) {
                model.addAttribute("movieName", movieName);
                model.addAttribute("order", order);
                return "book-final";

            }
        }
        return "404";
    }

}
