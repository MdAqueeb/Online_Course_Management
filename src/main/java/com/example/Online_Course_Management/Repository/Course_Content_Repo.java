package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Course_Content;

@Repository
public interface Course_Content_Repo extends JpaRepository<Course_Content, Long> {
    
}
