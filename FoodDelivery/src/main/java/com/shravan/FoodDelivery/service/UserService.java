package com.shravan.FoodDelivery.service;

import com.shravan.FoodDelivery.Model.User;
import com.shravan.FoodDelivery.Model.UserAuthenticationToken;
import com.shravan.FoodDelivery.Model.UserTypes;
import com.shravan.FoodDelivery.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PTokenService pTokenService;

    public String UserSingUp(User newUser) {
        String newEmail=newUser.getEmail();
        User existinguser=userRepo.findByEmail(newEmail);
        if(existinguser!=null){
            return "Email Already in used";
        }
        String signUpPassword=newUser.getPassword();
        try {
            String encryptedPassword=PasswordEncryptor.encrypt(signUpPassword);
            newUser.setPassword(encryptedPassword);
            String Email= newUser.getEmail();
            if(Email.contains("@Admin.com")) {
                newUser.setUser(UserTypes.Admin);
                return "Admin Resister";
            }
            else{
                newUser.setUser(UserTypes.Normal);

            }
            userRepo.save(newUser);
            return "Resister";
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

        public String SingIn(String username, String password) {
        User existingUser=userRepo.findByUsername(username);
        if(existingUser==null){
            return "Not a valid UserName, Please sign up first !!!";
        }
        //password should be matched
        try{
            String encryptedPassword=PasswordEncryptor.encrypt(password);
            if(existingUser.getPassword().equals(encryptedPassword)){
                // return a token for this sign in
                UserAuthenticationToken token =new UserAuthenticationToken(existingUser);
                pTokenService.CreateToken(token);
                return token.getToken();
            }
            else{
                return "Invalid Credentials!!!";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later!!!";
        }
    }


    public User findById(Long id) {
        return userRepo.findById(id).get();
    }



}
