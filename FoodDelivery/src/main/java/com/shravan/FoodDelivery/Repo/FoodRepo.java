package com.shravan.FoodDelivery.Repo;

import com.shravan.FoodDelivery.Model.FoodItem;
import com.shravan.FoodDelivery.Model.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodRepo extends JpaRepository<FoodItem,Long> {



    //List<FoodItem> findByUser(UserTypes role);


    //List<FoodItem> findByRole(UserTypes role);
}
