package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{
    
}
