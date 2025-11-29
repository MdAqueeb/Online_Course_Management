package com.example.Online_Course_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online_Course_Management.Models.Cart;
import com.example.Online_Course_Management.Service.Cart_Service;

@RestController
@RequestMapping("/cart")
public class Cart_Controller {

    @Autowired
    private Cart_Service cart_service;

    // get cart 
    @GetMapping("/user/{id}")
    public ResponseEntity<Cart> getMethodName(@PathVariable("id") Long id) {
        Cart crt = cart_service.getCart(id);
        if(crt == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(crt,HttpStatus.OK);
    }
    
}
