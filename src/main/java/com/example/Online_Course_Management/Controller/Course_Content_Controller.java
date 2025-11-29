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

@RestController
public class Course_Content_Controller {

    @Autowired
    private Course_Content_Service crse_content;

    // add course content 
    @PostMapping("/add_content")
    public ResponseEntity<Course_Content> postMethodName(@RequestBody Course_Content entity) {
        Course_Content modules = crse_content.addCourseContent(entity);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }
    
    @GetMapping("/{module_id}")
    public ResponseEntity<List<Course_Content>> getModules(@PathVariable("module_id") Long crs_id) {
        List<Course_Content> modules = crse_content.getCourseContent(crs_id);
        if(modules == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }   
    // modify course content 
    // delete course content    

}
