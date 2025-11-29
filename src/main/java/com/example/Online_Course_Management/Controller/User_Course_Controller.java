package com.example.Online_Course_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Models.User_courses;
import com.example.Online_Course_Management.Service.User_Course_Service;

import jakarta.validation.Valid;

@RestController
public class User_Course_Controller {

    @Autowired
    private User_Course_Service usr_cr_ser;
    // add user course 
    @PostMapping("/addcourse")
    public ResponseEntity<User_courses> addCourse(@RequestBody @Valid User_courses crse){
        User_courses course = usr_cr_ser.AddUserCourse(crse);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }
    // remove user course 
    // get user course 
    @GetMapping("/getcourse/{user_id}/{id}")
    public ResponseEntity<User_courses> getUserCourse(@PathVariable("user_id") Long user_id, @PathVariable("id") Long id){
        User_courses course = usr_cr_ser.GetUsercourse(user_id, id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    // get all user courses 
    @GetMapping("/get_all_courses/{user_id}/")
    public ResponseEntity<List<User_courses>> getCourse(@PathVariable("user_id") Long user_id){
        List<User_courses> course = usr_cr_ser.GetUsercourses(user_id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
}
