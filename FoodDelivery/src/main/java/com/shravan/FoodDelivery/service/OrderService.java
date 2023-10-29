package com.shravan.FoodDelivery.service;


import com.shravan.FoodDelivery.Model.Order;
import com.shravan.FoodDelivery.Model.User;
import com.shravan.FoodDelivery.Model.UserTypes;
import com.shravan.FoodDelivery.Repo.IorderRepo;

import com.shravan.FoodDelivery.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    IorderRepo iorderRepo;
    @Autowired
    UserService userService;
    @Autowired
    FoodService foodService;
    @Autowired
    UserRepo userRepo;

    public String orderPlaces(String email, Order order) {
       User user=userRepo.findFirstByEmail(email);
        UserTypes role=user.getUser();
       if(role==UserTypes.Normal) {
           order.setTime(LocalTime.now());
           iorderRepo.save(order);


           return "Order placed successfully";
       }
       else{
           return "Not order FoodItem";
       }

    }

    public List<Order> gethestory(String email) {
        User user = userRepo.findFirstByEmail(email);
        UserTypes role = user.getUser();

        if (role == UserTypes.Normal) {
            return iorderRepo.findAll();
        }

        return Collections.emptyList();
    }
}
