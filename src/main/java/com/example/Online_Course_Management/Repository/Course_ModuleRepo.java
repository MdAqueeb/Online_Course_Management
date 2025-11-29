package com.example.Online_Course_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Course_Module;

@Repository
public interface Course_ModuleRepo extends JpaRepository<Course_Module, Long>{

    @Query(value = "SELECT * FROM course_module WHERE course_id = :crs_id AND ORDERBY module_sequence", nativeQuery = true)
    List<Course_Module> findByCourseId(@Param("crs_id") Long crs_id);
    
}
