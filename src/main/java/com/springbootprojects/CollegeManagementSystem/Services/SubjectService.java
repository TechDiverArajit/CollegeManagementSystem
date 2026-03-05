package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.SubjectEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
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
}
