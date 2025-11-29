package com.example.Online_Course_Management.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Course_Module;
import com.example.Online_Course_Management.Service.Course_Module_Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/course")
public class Course_Module_Controller {

    private Course_Module_Service module_Service;
    // add module  
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
    @GetMapping("{course_id}/modules")
    public ResponseEntity<List<Course_Module>> getModules(@PathVariable("course_id") Long crs_id) {
        List<Course_Module> modules = module_Service.getCourseModules(crs_id);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }   
    


}

