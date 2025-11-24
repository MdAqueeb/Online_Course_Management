package com.example.Online_Course_Management.Models;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long payment_id;

    @Column(name = "tatal_amount", nullable = false, columnDefinition="DECIMAL(10,2)")
    @NotNull
    private double total_amount;

    @Column(name = "paid", nullable = false)
    @NotNull
    @Builder.Default
    private isPaid paid = isPaid.FALSE;

    @CreatedDate
    @NotNull
    @Column(name = "payment_date", nullable = false)
    private LocalDate payment_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_course_id", nullable = false)
    @NotNull
    private User_courses user_course;

    enum isPaid{
        TRUE,
        FALSE
    }
}
