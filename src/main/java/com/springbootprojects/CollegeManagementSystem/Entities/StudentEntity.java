package com.springbootprojects.CollegeManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "studentEntities")
    private List<ProfessorEntity> professorEntityList;
    private List<SubjectEntity> subjectEntities;


}
