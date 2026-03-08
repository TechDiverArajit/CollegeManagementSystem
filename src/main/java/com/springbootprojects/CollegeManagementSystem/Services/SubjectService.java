package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.SubjectEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.ProfessorRepository;
import com.springbootprojects.CollegeManagementSystem.Repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }

    public SubjectDTO getSubjectByID(Long id) {
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElse(null);
        return modelMapper.map(subjectEntity,SubjectDTO.class);

    }

    public List<SubjectDTO> getAllSubject() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        return subjectEntities.stream().map(subjectEntity -> modelMapper.map(subjectEntity,SubjectDTO.class)).collect(Collectors.toList());
    }

    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        SubjectEntity subject = modelMapper.map(subjectDTO,SubjectEntity.class);
        SubjectEntity savedSubject = subjectRepository.save(subject);
        return modelMapper.map(savedSubject,SubjectDTO.class);
    }

    public SubjectDTO assignProfessorToSubject(Long subId, Long profId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subId);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(profId);

        SubjectEntity subjectEntity1 = subjectEntity.flatMap(subject ->
                professorEntity.map(professor -> {
                    subject.setProfessor(professor);
                    return subjectRepository.save(subject);
                })).orElse(null);
        return modelMapper.map(subjectEntity1,SubjectDTO.class);
    }
}
