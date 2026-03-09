package com.springbootprojects.CollegeManagementSystem.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "professor" ,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SubjectEntity> subjectEntities;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_professor_info" ,
             joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<StudentEntity> studentEntities;
}
