package com.example.Online_Course_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online_Course_Management.Models.Cart;
import com.example.Online_Course_Management.Service.Cart_Service;


@Controller
@RequestMapping("/cart")
public class Cart_Controller {

    @Autowired
    private Cart_Service cart_service;

    // get cart 
    @GetMapping("/user/{id}")
    public ResponseEntity<Cart> getMethodName(@RequestParam("id") Long id) {
        Cart crt = cart_service.getCart(id);
        return new ResponseEntity<>(crt,HttpStatus.OK);
    }
    
}
