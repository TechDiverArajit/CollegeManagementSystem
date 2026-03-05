package com.springbootprojects.CollegeManagementSystem.DTOs;

import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.SubjectEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String title;
    private List<SubjectEntity> subjectEntities;
    private List<StudentEntity> studentEntities;
}
