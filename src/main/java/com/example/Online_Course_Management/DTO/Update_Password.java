package com.example.Online_Course_Management.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Update_Password {


    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$&_])[A-Za-z0-9@#$&_]{8,}$",message="Invalid password it must 8 characters, atleast one capital letter and symbols")
    private String password;
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$&_])[A-Za-z0-9@#$&_]{8,}$",message="Invalid password it must 8 characters, atleast one capital letter and symbols")
    private String confirm_password;
}
