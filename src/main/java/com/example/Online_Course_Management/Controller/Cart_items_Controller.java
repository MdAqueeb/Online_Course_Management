package com.example.Online_Course_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Cart_items;
import com.example.Online_Course_Management.Models.Course;
import com.example.Online_Course_Management.Service.Cart_Item_Service;

import jakarta.validation.Valid;

@RestController
public class Cart_items_Controller {

    @Autowired
    private Cart_Item_Service crt_item;
    // get all cart items 
    // get particular cart items
    // remove cart items
    @DeleteMapping("/delete_cartItem/{id}")
    public ResponseEntity<Cart_items> deleteCartItem(@PathVariable("id") Long id){
        Cart_items course = crt_item.deleteCartItem(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    // remove all cart 
    @DeleteMapping("/clear_cart")
    public ResponseEntity<String> deleteCartItem(){
        String course = crt_item.deleteCartItem();
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    // add cart items
    @PostMapping("/addCartItem")
    public ResponseEntity<Cart_items> addCartItem(@RequestBody @Valid Cart_items crse){
        Cart_items course = crt_item.AddCartItem(crse);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }
}
