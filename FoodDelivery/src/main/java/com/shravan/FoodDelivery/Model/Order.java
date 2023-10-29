package com.shravan.FoodDelivery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_table")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long  orderID;
    private Long foodItemID;
    private LocalTime time;
    private double quantity;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
