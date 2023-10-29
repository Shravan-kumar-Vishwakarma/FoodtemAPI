package com.shravan.FoodDelivery.Repo;

import com.shravan.FoodDelivery.Model.FoodItem;
import com.shravan.FoodDelivery.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IorderRepo extends JpaRepository<Order,Integer> {

}
