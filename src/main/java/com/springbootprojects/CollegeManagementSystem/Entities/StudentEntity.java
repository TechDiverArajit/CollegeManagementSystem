package com.springbootprojects.CollegeManagementSystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "studentEntities")
    @JsonIgnore
    private List<ProfessorEntity> professorEntityList;
    @ManyToMany
    @JoinTable(name = "student_subject_table" ,
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    @JsonIgnore
    private List<SubjectEntity> subjectEntities;


}

