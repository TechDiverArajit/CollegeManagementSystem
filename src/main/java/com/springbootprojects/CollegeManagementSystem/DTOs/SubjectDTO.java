package com.springbootprojects.CollegeManagementSystem.DTOs;


import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Long id;
    private String title;
    private ProfessorEntity professor;
    private List<StudentEntity> studentEntities;
}
