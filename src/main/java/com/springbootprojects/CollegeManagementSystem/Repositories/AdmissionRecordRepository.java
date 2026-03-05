package com.springbootprojects.CollegeManagementSystem.Repositories;

import com.springbootprojects.CollegeManagementSystem.Entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity , Long> {

}
