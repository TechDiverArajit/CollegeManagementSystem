package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.ProfessorDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    public ProfessorService(ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }


    public ProfessorDTO getProfessorByID(Long id) {
        ProfessorEntity professor = professorRepository.findById(id).orElse(null);
        return modelMapper.map(professor,ProfessorDTO.class);
    }

    public List<ProfessorDTO> getAllProfessor() {
        List<ProfessorEntity> professorEntityList = professorRepository.findAll();
        return professorEntityList.stream().map(professorEntity -> modelMapper.map(professorEntity,ProfessorDTO.class)).collect(Collectors.toList());
    }

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        ProfessorEntity professor = modelMapper.map(professorDTO,ProfessorEntity.class);
        ProfessorEntity savedProfessor = professorRepository.save(professor);
        return modelMapper.map(savedProfessor,ProfessorDTO.class);
    }
}
