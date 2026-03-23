package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Exceptions.ResourceNotFoundException;
import com.springbootprojects.CollegeManagementSystem.Services.AdmissionRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/AdmissionRecord")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AdmissionRecordDTO> getAdmissionRecordByID(@PathVariable Long id){
        Optional<AdmissionRecordDTO> admissionRecordDTO = admissionRecordService.getAdmissionRecordByID(id);
        return admissionRecordDTO
                .map(admissionRecordDTO1 -> ResponseEntity.ok(admissionRecordDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Admission Record with id"+id+"not found"));
    }

    @GetMapping
    public List<AdmissionRecordDTO> getAllAdmissionRecord(){
        return admissionRecordService.getAllAdmissionRecord();
    }

    @PostMapping
    public AdmissionRecordDTO createAdmission(@RequestBody AdmissionRecordDTO admissionRecordDTO ){
        return admissionRecordService.createAdmission(admissionRecordDTO);
    }

    @GetMapping(path = "/{admsnId}/AssignStudentIdAdmissionRecord/{studentId}")
    public AdmissionRecordDTO assignStudentIdToAdmissionRecord(@PathVariable Long admsnId ,
                                                               @PathVariable Long studentId){
        return admissionRecordService.assignStudentIdToAdmissionRecord(admsnId , studentId);
    }




}
