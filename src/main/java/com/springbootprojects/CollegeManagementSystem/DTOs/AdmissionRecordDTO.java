package com.springbootprojects.CollegeManagementSystem.DTOs;

import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionRecordDTO {
    private Long id;
    private Integer fees;
    private StudentEntity student;
}
