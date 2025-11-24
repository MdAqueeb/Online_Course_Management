
package com.example.Online_Course_Management.Controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.DTO.Update_Password;
import com.example.Online_Course_Management.Models.User;
import com.example.Online_Course_Management.Service.User_Service;

import jakarta.validation.Valid;

@RestController
public class User_Controller {

    @Autowired
    private User_Service usr_service;

    // get user -> specific user 
    @GetMapping("/user/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User fnd_user = usr_service.findUser(id);
        if(fnd_user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fnd_user,HttpStatus.OK);
    }
    // get allusers -> admin
    @GetMapping("/admin/users")
    ResponseEntity<Page<User>> getUser(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        Page<User> fnd_user = usr_service.getAllUsers(page, size);
        return new ResponseEntity<>(fnd_user,HttpStatus.OK);
    }
    // add user 
    @PostMapping("/user/adduser")
    ResponseEntity<User> addUser(@RequestBody @Valid User nw_user){
        User ad_usr = usr_service.Adduser(nw_user);
        if(ad_usr == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ad_usr,HttpStatus.CREATED);
    }
    // update user 
    @PutMapping("/user/modify/{id}")
    ResponseEntity<User> modifyUser(@RequestBody @Valid User nw_user, @PathVariable("id") Long id){
        User update_usr = usr_service.Modifyuser(nw_user, id);
        if(update_usr == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(update_usr,HttpStatus.ACCEPTED);
    }

    // delete user -> admin 
    @DeleteMapping("/admin/user/remove/{id}")
    ResponseEntity<User> removeUser(@PathVariable("id") Long id){
        User ad_usr = usr_service.Removeuser(id);
        if(ad_usr == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ad_usr,HttpStatus.OK);
    }
    // update_password 
    @PatchMapping("/user/{id}")
    ResponseEntity<User> update_password(@PathVariable("id") Long id, @RequestBody @Valid Update_Password password){
        User ad_usr = usr_service.Update_password(id, password);
        if(ad_usr == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ad_usr,HttpStatus.OK);
    }
    // update_profilePic 
    // update_username 
}


