package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.SignUpDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.UserDTO;
import com.springbootprojects.CollegeManagementSystem.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;



    @PostMapping("/SignUp")
    public ResponseEntity<UserDTO> createUser(@RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.createUser(signUpDTO));
    }

}
