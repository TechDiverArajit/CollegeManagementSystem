package com.springbootprojects.CollegeManagementSystem.Repositories;

import com.springbootprojects.CollegeManagementSystem.Entities.AdmissionRecordEntity;
import com.springbootprojects.CollegeManagementSystem.Entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
