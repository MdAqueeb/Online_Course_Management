package com.example.Online_Course_Management.Models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long cart_id; 

    @OneToOne
    @JoinColumn(name = "user_id")
    @Column(name = "user", nullable = false)
    @NotNull
    private User user;

    @Column(name = "cart_total_amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private double cart_total_amount; 
    
}

