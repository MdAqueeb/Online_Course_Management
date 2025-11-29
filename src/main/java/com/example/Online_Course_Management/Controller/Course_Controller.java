

package com.example.Online_Course_Management.Controller;

// import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Service.Course_Service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class Course_Controller {

    @Autowired
    private Course_Service course_ser;

    //add course 
    @PostMapping("/addcourse")
    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course crse){
        Course course = course_ser.Addcourse(crse);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }

    //modify course_details 
    @PutMapping("/modify_course/{id}")
    public ResponseEntity<Course> modifyCourse(@RequestBody @Valid Course crs,@PathVariable("id") Long id){
        Course course = course_ser.UpdateCourse(crs, id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(course,HttpStatus.ACCEPTED);
    }

    //delete course 
    @DeleteMapping("/delete_course/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Long id){
        Course course = course_ser.deleteCourse(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    //get course 
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id){
        Course course = course_ser.Getcourse(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("/All_Course")
    public ResponseEntity<Page<Course>> getCourse(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<Course> course = course_ser.GetAllcourse(page, size);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
}