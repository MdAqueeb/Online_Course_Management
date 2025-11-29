package com.example.Online_Course_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Models.Course_Module;
import com.example.Online_Course_Management.OnlineCourseManagementApplication;
import com.example.Online_Course_Management.Repository.CourseRepo;
import com.example.Online_Course_Management.Repository.Course_ModuleRepo;

@Service
public class Course_Module_Service {

    private final Online_Course_Management.OnlineCourseManagementApplication onlineCourseManagementApplication;

    @Autowired
    private Course_ModuleRepo crse_mdl_repo;

    @Autowired
    private CourseRepo crse_repo;

    Course_Module_Service(Online_Course_Management.OnlineCourseManagementApplication onlineCourseManagementApplication) {
        this.onlineCourseManagementApplication = onlineCourseManagementApplication;
    }

    public List<Course_Module> getCourseModules(Long crs_id) {
        Optional<Course> crs = crse_repo.findById(crs_id);
        if(!crs.isPresent()){
            return null;
        }

        return crse_mdl_repo.findByCourseId(crs_id);
    }


    public Course_Module addCourseModule(Course_Module entity) {
        return crse_mdl_repo.save(entity);
    }
    
}
