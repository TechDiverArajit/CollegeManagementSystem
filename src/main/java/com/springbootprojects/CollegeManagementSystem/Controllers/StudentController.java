package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{id}")
    public StudentDTO getStudentByID(@PathVariable Long id){
        return studentService.getStudentByID(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }




}
