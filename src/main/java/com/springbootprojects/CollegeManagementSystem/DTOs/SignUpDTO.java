package com.springbootprojects.CollegeManagementSystem.DTOs;

import lombok.Data;

@Data
public class SignUpDTO {
    private Long id;
    private String emailID;
    private String password;
    private String name;
}
