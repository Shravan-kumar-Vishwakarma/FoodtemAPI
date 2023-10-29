package com.shravan.FoodDelivery.service;

import com.shravan.FoodDelivery.Model.FoodItem;
import com.shravan.FoodDelivery.Model.User;
import com.shravan.FoodDelivery.Model.UserTypes;
import com.shravan.FoodDelivery.Repo.FoodRepo;
import com.shravan.FoodDelivery.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    FoodRepo foodRepo;
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;

    public String FoodItemAdd(FoodItem newfood, Long id) {
        Optional<User> user=userRepo.findById(id);
        if(user.isPresent()) {
            String Email = user.get().getEmail();

            UserTypes role = user.get().getUser();

            if (role == UserTypes.Admin) {
                foodRepo.save(newfood);
                return "Food item created successfully";
            } else {
                return "Permission denied. Only admins can create food items.";
            }
        }
        else{
            return "User not Found!";
        }
    }


    public List<FoodItem> getFoodItem(String email, String password) throws NoSuchAlgorithmException, AuthenticationException {

        User user = userRepo.findFirstByEmail(email);

        if (user != null) {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (user.getPassword().equals(encryptedPassword)) {
                return foodRepo.findAll();
            } else {
                throw new AuthenticationException("Incorrect email/password.");
            }
        } else {
            throw new AuthenticationException("User not found.");
        }
    }


    public String updateFoodItem(Long id, double price, String email) {
    User user=userRepo.findFirstByEmail(email);
         UserTypes role=user.getUser();
         if(role==UserTypes.Admin) {
             Optional<FoodItem> food = foodRepo.findById(id);
             if (food.isPresent()) {
                 FoodItem foodItem = food.get();
                 foodItem.setPrice(price);
                 foodRepo.save(foodItem);
                 return "Food item updated successfully.";
             } else {
                 return "Food item not found.";
             }

    }else{
             return "User not found or unauthorized to update the food item.";
         }
    }

    public String DeleteFood(Long id, String email) {
        User user=userRepo.findFirstByEmail(email);
        UserTypes role=user.getUser();
        if(role==UserTypes.Admin){
            foodRepo.deleteById(id);
            return "Delete BY FOODItem";
        }
        return "Not Exist User Id";
    }


    public Object getFoodItem(Long  foodItemID) {
        return userService.findById(foodItemID);
    }
}
