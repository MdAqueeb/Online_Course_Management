

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
@Tag(name = "Course", description = "Operations related to Course")
public class Course_Controller {

    @Autowired
    private Course_Service course_ser;

    //add course 
    @PostMapping("/addcourse")
    @Operation(summary = "add course", description = "Returns the added course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "return course created"),
            @ApiResponse(responseCode = "409", description = "The course details invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course crse){
        Course course = course_ser.Addcourse(crse);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }

    //modify course_details 
    @PutMapping("/modify_course/{id}")
    @Operation(summary = "Update course details", description = "Returns the modified course details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted the new details of course"),
            @ApiResponse(responseCode = "304", description = "New details invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Course> modifyCourse(@RequestBody @Valid Course crs,@PathVariable("id") Long id){
        Course course = course_ser.UpdateCourse(crs, id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(course,HttpStatus.ACCEPTED);
    }

    //delete course 
    @DeleteMapping("/delete_course/{id}")
    @Operation(summary = "delete specific course", description = "Returns deleted course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted successfully"),
            @ApiResponse(responseCode = "409", description = "Course id invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Long id){
        Course course = course_ser.deleteCourse(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    //get course 
    @GetMapping("/{id}")
    @Operation(summary = "Get particular Course", description = "Fetch specific course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "course founded"),
            @ApiResponse(responseCode = "404", description = "course not found or course id invlaid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id){
        Course course = course_ser.Getcourse(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    @Operation(summary = "Get list of courses", description = "Returns list of course ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get limited list of course"),
            @ApiResponse(responseCode = "409", description = "Conflict, while fetching the list of course"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/All_Course")
    public ResponseEntity<Page<Course>> getCourse(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<Course> course = course_ser.GetAllcourse(page, size);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
}