package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Exceptions.ResourceNotFoundException;
import com.springbootprojects.CollegeManagementSystem.Services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SubjectDTO> getSubjectByID(@PathVariable Long id){
        Optional<SubjectDTO> subjectDTO = subjectService.getSubjectByID(id);
        return subjectDTO.map(subjectDTO1 -> ResponseEntity.ok(subjectDTO1)).orElseThrow(()->new ResourceNotFoundException("Subject with id "+id+" not found"));
    }

    @GetMapping
    public List<SubjectDTO> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }

    @GetMapping(path = "/{subId}/AssignProfessor/{profId}")
    public SubjectDTO assignProfessorToSubject(@PathVariable Long subId,
                                              @PathVariable Long profId){
        return subjectService.assignProfessorToSubject(subId,profId);
    }

}
