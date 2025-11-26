package com.example.Online_Course_Management.Models;

import java.time.LocalDate;
// import java.util.List;

import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class User_courses {
    @Id
    @Column(name = "user_course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_course_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    // @Fetch(FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @NotNull
    private Course course;

    @NotNull
    @Column(name = "user_course_progress", nullable = false)
    private int user_course_progress;

    @Enumerated(EnumType.STRING)
    @Column(name = "certificate", nullable = false)
    // @NotNull
    @Builder.Default
    private isCertificated certificate = isCertificated.FALSE;

    @OneToOne(mappedBy = "user_course", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnore
    private Payment payment;

    enum isCertificated{
        TRUE, 
        FALSE
    }
}
