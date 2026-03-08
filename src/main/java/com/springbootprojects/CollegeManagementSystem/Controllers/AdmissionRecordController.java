package com.springbootprojects.CollegeManagementSystem.Controllers;

import com.springbootprojects.CollegeManagementSystem.DTOs.AdmissionRecordDTO;
import com.springbootprojects.CollegeManagementSystem.DTOs.SubjectDTO;
import com.springbootprojects.CollegeManagementSystem.Services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/AdmissionRecord")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping(path = "/{id}")
    public AdmissionRecordDTO getAdmissionRecordByID(@PathVariable Long id){
        return admissionRecordService.getAdmissionRecordByID(id);
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
