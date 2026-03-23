package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.Exceptions.ResourceNotFoundException;
import com.springbootprojects.CollegeManagementSystem.Services.StudentService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Long id){
        Optional<StudentDTO> studentDTO = studentService.getStudentByID(id);
        return studentDTO.map(studentDTO1 -> ResponseEntity.ok(studentDTO1)).orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @GetMapping(path = "/{sId}/assignSubjectsToStudents/{subjectId}")
    public StudentDTO assignSubjectsToStudents(@PathVariable Long sId ,
                                    @PathVariable Long subjectId){
        return studentService.assignSubjectsToStudents(sId , subjectId);
    }

    @DeleteMapping(path = "/{sId}")
    public Boolean deleteStudent(@PathVariable Long sId){
        return studentService.deleteStudent(sId);
    }





}
