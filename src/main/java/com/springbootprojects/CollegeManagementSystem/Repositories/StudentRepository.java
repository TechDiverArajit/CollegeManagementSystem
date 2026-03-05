package com.springbootprojects.CollegeManagementSystem.Repositories;

import com.springbootprojects.CollegeManagementSystem.Entities.AdmissionRecordEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
