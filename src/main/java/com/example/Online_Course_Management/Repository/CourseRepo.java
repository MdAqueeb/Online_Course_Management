package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
    
}
