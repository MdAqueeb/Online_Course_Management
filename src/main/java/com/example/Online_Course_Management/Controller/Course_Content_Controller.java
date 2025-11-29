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

import com.example.Online_Course_Management.Models.Course_Content;
// import com.example.Online_Course_Management.Models.Course_Module;
import com.example.Online_Course_Management.Service.Course_Content_Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class Course_Content_Controller {

    @Autowired
    private Course_Content_Service crse_content;

    // add course content 
    @PostMapping("/add_content")
    @Operation(summary = "add course content", description = "course content is created")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course content is added"),
            @ApiResponse(responseCode = "409", description = "The course content details is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Course_Content> postMethodName(@RequestBody Course_Content entity) {
        Course_Content modules = crse_content.addCourseContent(entity);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.CREATED);
    }
    @Operation(summary = "Get all course content of specific Module", description = "Returns the specific module all contents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch all module content"),
            @ApiResponse(responseCode = "404", description = "The module is not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{module_id}")
    public ResponseEntity<List<Course_Content>> getModules(@PathVariable("module_id") Long crs_id) {
        List<Course_Content> modules = crse_content.getCourseContent(crs_id);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }   
    // modify course content 
    // delete course content    

}
