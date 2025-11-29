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

// import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Models.User_courses;
import com.example.Online_Course_Management.Service.User_Course_Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "User Courses", description = "Operations related to user courses")
public class User_Course_Controller {

    @Autowired
    private User_Course_Service usr_cr_ser;
    // add user course 
    @PostMapping("/addcourse")
    @Operation(summary = "Buying a course", description = "Returns buyed course of the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully buyed course"),
            @ApiResponse(responseCode = "409", description = "The User id is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
    @Operation(summary = "Get User specific course", description = "Returns specific course of user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch buyed Course details"),
            @ApiResponse(responseCode = "404", description = "The course not found or user is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<User_courses> getUserCourse(@PathVariable("user_id") Long user_id, @PathVariable("id") Long id){
        User_courses course = usr_cr_ser.GetUsercourse(user_id, id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    // get all user courses 
    @GetMapping("/get_all_courses/{user_id}/")
    @Operation(summary = "Fetch specific user buyed all courses", description = "Returns all buyed courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all buyed courses"),
            @ApiResponse(responseCode = "409", description = "The User id is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<User_courses>> getCourse(@PathVariable("user_id") Long user_id){
        List<User_courses> course = usr_cr_ser.GetUsercourses(user_id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
}
