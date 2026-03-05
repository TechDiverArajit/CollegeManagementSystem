package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public StudentDTO getStudentByID(Long id) {
        StudentEntity student = studentRepository.findById(id).orElse(null);
        return modelMapper.map(student,StudentDTO.class);
    }

    public List<StudentDTO> getAllStudent() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDTO>  studentDTOS = studentEntities.stream().map(students -> modelMapper.map(students,StudentDTO.class)).collect(Collectors.toList());
        return studentDTOS;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentEntity student = modelMapper.map(studentDTO,StudentEntity.class);
        StudentEntity savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent , StudentDTO.class);

    }
}
