package com.shravan.FoodDelivery.Controller;

import com.shravan.FoodDelivery.Model.Order;
import com.shravan.FoodDelivery.Model.User;
import com.shravan.FoodDelivery.service.OrderService;
import com.shravan.FoodDelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @PostMapping("place/order")
    public String orderPlaces(@RequestParam String Email, @RequestBody Order order){
        return orderService.orderPlaces(Email,order);
    }
    @GetMapping("history")
    public List<Order> gethestory(@RequestParam String Email){
        return orderService.gethestory(Email);
    }

}
