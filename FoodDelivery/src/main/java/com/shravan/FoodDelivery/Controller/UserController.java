package com.shravan.FoodDelivery.Controller;

import com.shravan.FoodDelivery.Model.User;
import com.shravan.FoodDelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //SingUp
    @PostMapping("SingUp")
    public String UserSingUp(@RequestBody User newUser) {
        return userService.UserSingUp(newUser);
    }

    //SingIn
    @PostMapping("SignIn/{username}/{password}")
    public String SingIn(@PathVariable String username, @PathVariable String password) {
        return userService.SingIn(username, password);
    }

}
