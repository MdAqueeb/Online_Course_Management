package com.example.Online_Course_Management.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Course_Module;
import com.example.Online_Course_Management.Service.Course_Module_Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController

@RequestMapping("/course")
public class Course_Module_Controller {

    private Course_Module_Service module_Service;
    // add module  
    @Operation(summary = "Add course module", description = "Returns the added course module")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Module is Added in specific course"),
            @ApiResponse(responseCode = "409", description = "The course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("addmodules")
    public ResponseEntity<Course_Module> postMethodName(@RequestBody Course_Module entity) {
        Course_Module modules = module_Service.addCourseModule(entity);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }
    
    // remove module 
    // update modules 
    
    // get modules
    @Operation(summary = "Get all modules of specific course", description = "Returns modules of specific course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns list of modules of the course"),
            @ApiResponse(responseCode = "404", description = "The course is not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("{course_id}/modules")
    public ResponseEntity<List<Course_Module>> getModules(@PathVariable("course_id") Long crs_id) {
        List<Course_Module> modules = module_Service.getCourseModules(crs_id);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }   
    


}

