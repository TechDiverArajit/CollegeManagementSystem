package com.springbootprojects.CollegeManagementSystem.Services;

import com.springbootprojects.CollegeManagementSystem.DTOs.StudentDTO;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.SubjectEntity;
import com.springbootprojects.CollegeManagementSystem.Repositories.StudentRepository;
import com.springbootprojects.CollegeManagementSystem.Repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
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

    public StudentDTO assignSubjectsToStudents(Long sId, Long subjectId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(sId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        StudentEntity studentEntity1 = studentEntity.flatMap(student ->
                subjectEntity.map(subject -> {
                    student.getSubjectEntities().add(subject);
                    return studentRepository.save(student);
                })).orElse(null);
        return modelMapper.map(studentEntity1, StudentDTO.class);
    }
}
