package com.example.Online_Course_Management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Course_Management.Models.Cart_items;
import com.example.Online_Course_Management.Repository.Cart_item_Repo;

// import jakarta.validation.Valid;

@Service
public class Cart_Item_Service {

    @Autowired
    private Cart_item_Repo crt_item_repo;

    public Cart_items AddCartItem(Cart_items crse) {
        return crt_item_repo.save(crse);
    }

    public String deleteCartItem() {
        crt_item_repo.deleteAll();
        return "Successfull";
    }

    public Cart_items deleteCartItem(Long id) {
        Optional<Cart_items> crt = crt_item_repo.findById(id);
        if(!crt.isPresent()){
            return null;
        }
        crt_item_repo.deleteById(id);
        return crt.get();
    }
    
}
