package com.shravan.FoodDelivery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @NotNull
    private String password;
    @Email
    private String email;
    @JsonIgnore
    @Enumerated(value = EnumType.STRING)
    private UserTypes user;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> orders;



}
