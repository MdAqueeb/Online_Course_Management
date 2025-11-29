package com.example.Online_Course_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.User_courses;

@Repository
public interface User_Course_Repo extends JpaRepository<User_courses, Long> {

    @Query(value = "SELECT * FROM User_courses WHERE user_id = :user_id", nativeQuery = true)
    List<User_courses> findByUserId(Long user_id);
    
}
