package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.User_courses;

@Repository
public interface User_Course_Repo extends JpaRepository<User_courses, Long> {
    
}
