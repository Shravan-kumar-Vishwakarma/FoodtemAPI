package com.shravan.FoodDelivery.service;


import com.shravan.FoodDelivery.Model.UserAuthenticationToken;
import com.shravan.FoodDelivery.Repo.PtokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PTokenService {
    @Autowired
    PtokenRepo ptokenRepo;

    public void CreateToken(UserAuthenticationToken token) {
        ptokenRepo.save(token);
    }


}
