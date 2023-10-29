package com.shravan.FoodDelivery.Controller;

import com.shravan.FoodDelivery.Model.FoodItem;
import com.shravan.FoodDelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;
@PostMapping("FoodItem/Add")
    public String FoodItemAdd(@RequestBody FoodItem newfood, @RequestParam Long id){
return foodService.FoodItemAdd(newfood,id);
}
    @GetMapping("getFood")
    public List<FoodItem> getFoodItem(@RequestParam String Email,@RequestParam String Password) throws NoSuchAlgorithmException, AuthenticationException {
        return foodService.getFoodItem(Email,Password);
    }

    @PutMapping("Update")
    public String updateFoodItem(@RequestParam Long id, @RequestParam double price, @RequestParam String Email) {
        return foodService.updateFoodItem(id, price, Email);
    }
    @DeleteMapping("Delete")
    public String DeleteFood(@RequestParam Long id,@RequestParam String Email){
    return foodService.DeleteFood(id,Email);
    }

}
