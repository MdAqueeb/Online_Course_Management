package com.example.Online_Course_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Course_Module;

@Repository
public interface Course_ModuleRepo extends JpaRepository<Course_Module, Long>{
    
}
