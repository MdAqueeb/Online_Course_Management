package com.example.Online_Course_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Repository.CourseRepo;

// import jakarta.validation.Valid;

@Service
public class Course_Service {

    @Autowired
    private CourseRepo course_repo;

    public Course Addcourse(Course crse) {
        Course crs = course_repo.save(crse);
        return crs;
    }

    public Course UpdateCourse(Course crs, Long id) {
        Optional<Course> courseOptional = course_repo.findById(id);
        if(!courseOptional.isPresent()){
            return null;
        }
        Course course = courseOptional.get();
        // course.setCourse_available(crs.getCourse_available());
        course.setCourse_author(crs.getCourse_author());
        course.setCourse_amount(crs.getCourse_amount());
        // course.setCourse_available(crs.getCourse_available());
        course.setCourse_title(crs.getCourse_title());
        course.setCourse_description(crs.getCourse_description());
        return course_repo.save(course);
    }

    public Course deleteCourse(Long id) {
        Optional<Course> courseOptional = course_repo.findById(id);
        if(!courseOptional.isPresent()){
            return null;
        }
        Course course = courseOptional.get();
        course_repo.deleteById(id);
        return course;
   }

    public Course Getcourse(Long id) {
        Optional<Course> courseOptional = course_repo.findById(id);
        if(!courseOptional.isPresent()){
            return null;
        }
        Course course = courseOptional.get();
        return course;
    }


    public Page<Course> GetAllcourse(int page, int size) {
        PageRequest courses = PageRequest.of(page,size);
        return course_repo.findAll(courses);
    }
    
}
