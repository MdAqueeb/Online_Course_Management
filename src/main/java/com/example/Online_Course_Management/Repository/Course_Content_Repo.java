package com.example.Online_Course_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Course_Content;

@Repository
public interface Course_Content_Repo extends JpaRepository<Course_Content, Long> {

    @Query(value = "SELECT * FROM course_content WHERE course_module_id = :crs_id AND ORDERBY content_sequence", nativeQuery = true)
    List<Course_Content> findByModuleId(Long crs_id);
    
}
