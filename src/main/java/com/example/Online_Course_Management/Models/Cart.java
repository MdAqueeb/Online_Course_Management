package com.example.Online_Course_Management.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "cart_id", nullable = false)
    private Long cart_id; 

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    // @Column(name = "user", nullable = false)
    @NotNull
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    @Builder.Default
    private List<Cart_items> cart_items = new ArrayList<>();

    @Column(name = "cart_total_amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private double cart_total_amount; 
    
}

