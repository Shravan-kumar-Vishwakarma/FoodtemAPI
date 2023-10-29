package com.shravan.FoodDelivery.Repo;

import com.shravan.FoodDelivery.Model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {



}
