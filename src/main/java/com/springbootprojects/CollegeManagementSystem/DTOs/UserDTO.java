package com.springbootprojects.CollegeManagementSystem.DTOs;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String emailID;
    private String password;
}
