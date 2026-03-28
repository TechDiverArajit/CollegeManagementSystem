package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.LoginDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.SignUpDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.UserDTO;
import com.springbootprojects.CollegeManagementSystem.Services.AuthService;
import com.springbootprojects.CollegeManagementSystem.Services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    private final AuthService authService;



    @PostMapping("/SignUp")
    public ResponseEntity<UserDTO> createUser(@RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.createUser(signUpDTO));
    }

    @PostMapping("/Login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO , HttpServletRequest request , HttpServletResponse response){
        String token = authService.loginUser(loginDTO);
        Cookie cookie = new Cookie("token" , token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }

}
