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
@Table(name = "Professor")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    
    private List<SubjectEntity> subjectEntities;
    @ManyToMany
    @JoinTable(name = "student_professor_info" ,
             joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<StudentEntity> studentEntities;
}
