package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.ProfessorDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.ProfessorRepository;
import com.springbootprojects.CollegeManagementSystem.Repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public ProfessorService(ProfessorRepository professorRepository, StudentRepository studentRepository, ModelMapper modelMapper) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
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

    public ProfessorDTO assignStudentsToProfessor(Long pId, Long sId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(pId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(sId);

         ProfessorEntity professorEntity1 = professorEntity.flatMap(professor ->
                studentEntity.map(student -> {
                    professor.getStudentEntities().add(student);
                    return professorRepository.save(professor);
                })).orElse(null);

         return modelMapper.map(professorEntity1,ProfessorDTO.class);
    }
}
