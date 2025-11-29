package com.example.Online_Course_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.User;
import com.example.Online_Course_Management.Models.User_courses;
import com.example.Online_Course_Management.Repository.UserRepo;
import com.example.Online_Course_Management.Repository.User_Course_Repo;

// import jakarta.validation.Valid;

@Service
public class User_Course_Service {

    @Autowired
    private User_Course_Repo usr_cr_reop;

    @Autowired 
    private UserRepo usr_repo;

    public User_courses AddUserCourse(User_courses crse) {
        return usr_cr_reop.save(crse);
    }

    public User_courses GetUsercourse(Long user_id, Long id) {
        if(!find_user(user_id).isPresent()){
            return null;
        }
        return usr_cr_reop.findById(id).get();
    }

    private Optional<User> find_user(Long usr){
        return usr_repo.findById(usr);
    }

    public List<User_courses> GetUsercourses(Long user_id) {
        if(!find_user(user_id).isPresent()){
            return null;
        }
        return usr_cr_reop.findByUserId(user_id);
    }
    
}
