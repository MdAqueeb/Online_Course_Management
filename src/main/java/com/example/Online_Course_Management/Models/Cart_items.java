package com.example.Online_Course_Management.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart_items")
@NoArgsConstructor
@AllArgsConstructor
public class Cart_items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @NotNull
    private Long cart_item_id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @NotNull
    private Course course;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @NotNull
    private Cart cart;

    @Column(name = "amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    @NotNull
    private double amount;
    
}
