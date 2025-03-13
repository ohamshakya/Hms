package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.PatientDto;
import com.project.hms.service.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientController {

    @Autowired
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseWrapper<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        log.info("inside create patient: controller");
        PatientDto response = patientService.save(patientDto);
        return new ResponseWrapper<>(response,"created successfully", HttpStatus.CREATED.value());
    }

    @PutMapping("/update/{id}")
    public ResponseWrapper<PatientDto> updatePatient(@Valid @RequestBody PatientDto patientDto,@PathVariable Integer id) {
        log.info("inside update patient: controller");
        PatientDto response = patientService.update(patientDto,id);
        return new ResponseWrapper<>(response,"updated successfully",HttpStatus.OK.value());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseWrapper<PatientDto> getPatient(@PathVariable Integer id) {
        log.info("inside get patient by id: controller");
        PatientDto response = patientService.getById(id);
        return new ResponseWrapper<>(response,"retrieved successfully",HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<PatientDto>> getPatients(){
        log.info("get all patients : controller");
        List<PatientDto> response = patientService.getAll();
        return new ResponseWrapper<>(response,"retrieved successfully",HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deletePatient(@PathVariable Integer id) {
        log.info("inside delete patient: controller");
        patientService.delete(id);
        return new ResponseWrapper<>(null,"deleted successfully",HttpStatus.OK.value());
    }

    @GetMapping("/search")
    public ResponseWrapper<List<PatientDto>> searchPatient(@RequestParam String query) {
        log.info("inside search patient: controller");
        List<PatientDto> response = patientService.search(query);
        return new ResponseWrapper<>(response,"retrieved successfully",HttpStatus.OK.value());
    }

//    @PutMapping("/approve/{id}")
//    public ResponseWrapper<String> approveAppointment(@PathVariable Integer id) {
//        String response = patientService.approveAppointment(id);
//        return new ResponseWrapper<>(response+" has been approved","approved",HttpStatus.OK.value());
//    }
}
