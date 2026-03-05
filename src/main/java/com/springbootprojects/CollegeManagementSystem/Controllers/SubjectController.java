package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/{id}")
    public SubjectDTO getSubjectByID(@PathVariable Long id){
        return subjectService.getSubjectByID(id);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }
}
