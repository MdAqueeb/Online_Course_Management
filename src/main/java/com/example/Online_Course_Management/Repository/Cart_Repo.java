package com.example.Online_Course_Management.Repository;

// import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Online_Course_Management.Models.Cart;
// import com.example.Online_Course_Management.Models.User;

@Repository
public interface Cart_Repo extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT * FROM cart WHERE user_id = :id", nativeQuery = true)
    Cart findByUserId(@Param("id") Long id);

}
