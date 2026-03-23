package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.ProfessorDTO;
import com.springbootprojects.CollegeManagementSystem.Exceptions.ResourceNotFoundException;
import com.springbootprojects.CollegeManagementSystem.Services.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorByID(@PathVariable Long id){
        Optional<ProfessorDTO> professorDTO = professorService.getProfessorByID(id);
        return professorDTO.map(professorDTO1 -> ResponseEntity.ok(professorDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Professor with id "+id+" not found"));
    }

    @GetMapping
    public List<ProfessorDTO> getAllProfessor(){
        return professorService.getAllProfessor();
    }

    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professorDTO ){
        return professorService.createProfessor(professorDTO);
    }

    @GetMapping(path = "/{pId}/assignStudentsToProfessor/{sId}")
    public ProfessorDTO assignStudentsToProfessor(@PathVariable Long pId ,
                                        @PathVariable Long sId ){
        return professorService.assignStudentsToProfessor(pId,sId);
    }

}
