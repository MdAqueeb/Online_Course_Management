package com.example.Online_Course_Management.Models;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "courses")
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long course_id;

    // @Pattern(regexp = "^[A-Za-z ]{3,}[0-9#]*$")
    // @NotBlank
    // @Column(name = "course_name", nullable = false)
    // private String course_name;

    @Pattern(regexp = "^[A-Za-z #@$&|]{3,}$", message = "provide correct name")
    @NotBlank(message = "title should be not empty or null")
    @Column(name = "course_title", nullable = false)
    private String course_title;

    // i have to provide max lines for description
    @NotBlank(message = "course description not be empty or null")
    @Column(name = "course_description", nullable = false, columnDefinition = "TEXT")
    @Size(max = 500, message = "description can't exceed 500 characters")
    private String course_description;

    @Builder.Default
    // @NotNull(message = "course available is not null pass either true or false")
    @Enumerated(EnumType.STRING)
    @Column(name = "course_available", nullable = false)
    private isAvailable course_available = isAvailable.FALSE;

    @CreationTimestamp
    // @NotNull(message = "current date not be null")
    @Column(name = "course_created_at", nullable = false)
    private LocalDate course_created_at;

    @NotBlank(message = "author name should be not null or empty or only space")
    @Pattern(regexp = "^[A-Za-z ]{3,}$", message = "valid name, don't provide any digits or symbols")
    @Column(name = "course_author", nullable = false)
    private String course_author;

    @NotNull
    @Column(name = "course_amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    // @Builder.Default
    private double course_amount;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    // @Builder.Default
    private List<Course_Module> course_modules;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    // @Builder.Default
    private List<User_courses> course_user_course_id ;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    // @Builder.Default
    private List<Cart_items> cart_items ;

    enum isAvailable{
        TRUE, 
        FALSE
    }

    @PrePersist 
    void default_values(){
        if(course_available == null){
            course_available = isAvailable.FALSE;
        }
    }
}
