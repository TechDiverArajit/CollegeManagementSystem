package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.ProfessorDTO;
import com.springbootprojects.CollegeManagementSystem.Services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(path = "/{id}")
    public ProfessorDTO getProfessorByID(@PathVariable Long id){
        return professorService.getProfessorByID(id);
    }

    @GetMapping
    public List<ProfessorDTO> getAllProfessor(){
        return professorService.getAllProfessor();
    }

    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professorDTO ){
        return professorService.createProfessor(professorDTO);
    }
}
