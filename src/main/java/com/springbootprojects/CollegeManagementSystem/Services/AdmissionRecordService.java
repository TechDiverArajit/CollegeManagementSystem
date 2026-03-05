package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.AdmissionRecordEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.AdmissionRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepository admissionRecordRepository;
    private final ModelMapper modelMapper;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, ModelMapper modelMapper) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.modelMapper = modelMapper;
    }

    public AdmissionRecordDTO getAdmissionRecordByID(Long id) {
        AdmissionRecordEntity admissionRecordEntity = admissionRecordRepository.findById(id).orElse(null);
        return modelMapper.map(admissionRecordEntity, AdmissionRecordDTO.class);
    }

    public List<AdmissionRecordDTO> getAllAdmissionRecord() {
        List<AdmissionRecordEntity> admissionRecordEntities = admissionRecordRepository.findAll();
        return admissionRecordEntities.stream().map(admissionRecordEntity -> modelMapper.map(admissionRecordEntity,AdmissionRecordDTO.class)).collect(Collectors.toList());
    }

    public AdmissionRecordDTO createAdmission(AdmissionRecordDTO admissionRecordDTO) {
        AdmissionRecordEntity admissionRecord = modelMapper.map(admissionRecordDTO,AdmissionRecordEntity.class);
        AdmissionRecordEntity savedAdmissionRecord = admissionRecordRepository.save(admissionRecord);
        return modelMapper.map(savedAdmissionRecord,AdmissionRecordDTO.class);
    }
}
