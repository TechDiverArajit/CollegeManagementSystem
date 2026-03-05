package com.springbootprojects.CollegeManagementSystem.DTOs;

import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.SubjectEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private List<ProfessorEntity> professorEntityList;
    private List<SubjectEntity> subjectEntities;
}
