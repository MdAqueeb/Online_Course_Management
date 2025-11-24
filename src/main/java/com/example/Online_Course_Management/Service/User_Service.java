package com.example.Online_Course_Management.Service;

// import java.lang.StackWalker.Option;
// import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.DTO.Update_Password;
import com.example.Online_Course_Management.Models.User;
import com.example.Online_Course_Management.Repository.UserRepo;

// import jakarta.validation.Valid;

@Service
public class User_Service {

    @Autowired
    private UserRepo usr_repo;

    public User findUser(Long id) {
        
        Optional<User> usr = usr_repo.findById(id);
        if(!usr.isPresent()){
            return null;
        }

        return usr.get();
    }

    public Page<User> getAllUsers(int page, int size) {
        PageRequest users = PageRequest.of(page,size);
        return usr_repo.findAll(users);
    }

    public User Adduser(User nw_user) {
        return usr_repo.save(nw_user);
    }

    public User Modifyuser(User nw_user, Long id) {
        Optional<User> optionalUser = usr_repo.findById(id);
        if(!optionalUser.isPresent()){
            return null;
        }
        User old_usr = optionalUser.get();
        old_usr.setName(nw_user.getName());
        old_usr.setEmail(nw_user.getEmail());
        old_usr.setPassword(nw_user.getPassword());
        old_usr.setPhone_no(nw_user.getPhone_no());

        if(nw_user.getRole() != null){
            old_usr.setRole(nw_user.getRole());
        }

       return usr_repo.save(old_usr);
    }

    public User Removeuser(Long id) {
       Optional<User> usr = usr_repo.findById(id);
       if(!usr.isPresent()){
            return null;
       }

       usr_repo.deleteById(id);
       return usr.get();
    }

    public User Update_password(Long id, Update_Password password) {
        Optional<User> optionalUser = usr_repo.findById(id);
        if(!optionalUser.isPresent()){
            return null;
        }
        User usr = optionalUser.get();
        if(password.getPassword().equals(password.getConfirm_password())){
            usr.setPassword(password.getPassword());
        }
        else{
            throw new RuntimeException("The given password and confirm password not match");
        }
        
        return usr_repo.save(usr);
    }
    
}
