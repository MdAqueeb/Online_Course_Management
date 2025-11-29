package com.example.Online_Course_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.Course_Content;
import com.example.Online_Course_Management.Models.Course_Module;
import com.example.Online_Course_Management.Repository.Course_Content_Repo;
import com.example.Online_Course_Management.Repository.Course_ModuleRepo;

@Service
public class Course_Content_Service {

    @Autowired
    private Course_Content_Repo crse_repo;

    @Autowired
    private Course_ModuleRepo crse_module;

    public Course_Content addCourseContent(Course_Content entity) {
        return crse_repo.save(entity);
    }

    public List<Course_Content> getCourseContent(Long crs_id) {
        Optional<Course_Module> module = crse_module.findById(crs_id);
        if(!module.isPresent()){
            return null;
        }
        return crse_repo.findByModuleId(crs_id);
    }


    
}
