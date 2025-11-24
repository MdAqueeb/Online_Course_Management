package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Cart;

@Repository
public interface Cart_Repo extends JpaRepository<Cart, Long> {
    
}
