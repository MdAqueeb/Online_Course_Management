package com.example.Online_Course_Management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.Cart;
import com.example.Online_Course_Management.Models.User;
import com.example.Online_Course_Management.Repository.Cart_Repo;
import com.example.Online_Course_Management.Repository.UserRepo;

@Service
public class Cart_Service {

    @Autowired
    private Cart_Repo cart_repo;

    @Autowired
    private UserRepo user_repo;
    
    public Cart getCart(Long id) {
        Cart crt_optional = cart_repo.findByUserId(id);
        if(crt_optional == null){
            String value = createCart(id);
            if(value == "User not found"){
                return null;
            }
            crt_optional = cart_repo.findByUserId(id);
        }

        return crt_optional;

    }

    public String createCart(Long id){
        Optional<User> usr = user_repo.findById(id);
        if(!usr.isPresent()){
            return "User not found";
        }

        Cart existing = cart_repo.findByUserId(id);

        if(existing != null){
            return "Cart, Already Exist";
        }

        Cart crt = Cart.builder()
                    .user(usr.get())
                    .build();
        cart_repo.save(crt);
        return "created, Successfully";
    }
    
}
