package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.LoginDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public String loginUser(LoginDTO loginDTO) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmailID(),loginDTO.getPassword()));

        User user = (User) authentication.getPrincipal();

        return jwtService.GenerateJwt(user);
    }

}
