package com.shravan.FoodDelivery.Repo;

import com.shravan.FoodDelivery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String newUserName);
    User findByEmail(String newEmail);

    User findFirstByEmail(String email);
}
