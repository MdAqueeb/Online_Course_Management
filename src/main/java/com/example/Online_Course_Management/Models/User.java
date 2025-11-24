package com.example.Online_Course_Management.Models;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;

// import org.hibernate.validator.constraints.Length;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User {
    
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id; 

    @Column(name = "user_name", nullable = false)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{1}[A-Za-z ]{3,}[0-9]*$", message = "username not valid")
    private String name;

    @Builder.Default
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.STUDENT;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@$#&])[A-Za-z0-9]{8,}$",message="Invalid password it must 8 characters, atleast one capital letter and symbols")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Pattern(regexp = "^[A-Za-z]+[_]*[A-Za-z_]*[0-9]*@gmail\\.com$")
    private String email;

    @Column(name="phone_no", nullable = true, length = 10)
    @Pattern(regexp = "^[0-9]{10}$")
    // @NotBlank
    private String phone_no;

    @Column(name="date", nullable = false)
    @Builder.Default 
    @NotNull
    private LocalDate date = LocalDate.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User_courses> User_user_course_id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @NotNull
    @Column(nullable = false, unique = true)
    private Cart cart;

    enum Role{
        STUDENT, 
        ADMIN;
    }
}



// doghts: 
    // - Size anntotion and length annotation difference 
    //- GeneratedValue and its strategy why this annotation is importatn for autogeneration and how it generae
    //- For date, datetime, timestamp datatypes what datatype have to use in java 
    //- still any annotation is missing 


