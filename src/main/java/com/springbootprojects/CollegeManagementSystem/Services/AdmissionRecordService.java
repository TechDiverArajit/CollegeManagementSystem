package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.AdmissionRecordEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.AdmissionRecordRepository;
import com.springbootprojects.CollegeManagementSystem.Repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository, ModelMapper modelMapper) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
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

    public AdmissionRecordDTO assignStudentIdToAdmissionRecord(Long admsnId, Long studentId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admsnId);
        Optional<StudentEntity> student = studentRepository.findById(studentId);

        AdmissionRecordEntity admissionRecordEntity1 = admissionRecordEntity.flatMap(admissionRecord ->
                student.map(students -> {
                    admissionRecord.setStudent(students);
                    return admissionRecordRepository.save(admissionRecord);
                })).orElse(null);
        return modelMapper.map(admissionRecordEntity1 , AdmissionRecordDTO.class);
    }
}
