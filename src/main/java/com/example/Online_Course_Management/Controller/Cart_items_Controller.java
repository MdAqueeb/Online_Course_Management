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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class Cart_items_Controller {

    @Autowired
    private Cart_Item_Service crt_item;
    // get all cart items 
    // get particular cart items
    // remove cart items
    @DeleteMapping("/delete_cartItem/{id}")
    @Operation(summary = "Delete specific cartitem", description = "delete the cart item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cart item deleted"),
            @ApiResponse(responseCode = "409", description = "The User id is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Cart_items> deleteCartItem(@PathVariable("id") Long id){
        Cart_items course = crt_item.deleteCartItem(id);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    // remove all cart 
    @Operation(summary = "Delete all CartItems", description = "Delete all cart items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " all Cart items deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/clear_cart")
    public ResponseEntity<String> deleteCartItem(){
        String course = crt_item.deleteCartItem();
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    // add cart items
    @Operation(summary = "Add cart item", description = "Add cart item in Cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cart item created"),
            @ApiResponse(responseCode = "409", description = "The Details are invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/addCartItem")
    public ResponseEntity<Cart_items> addCartItem(@RequestBody @Valid Cart_items crse){
        Cart_items course = crt_item.AddCartItem(crse);
        if(course == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }
}
