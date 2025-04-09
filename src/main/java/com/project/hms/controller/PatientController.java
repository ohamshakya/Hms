package com.project.hms.controller;

import com.project.hms.common.utils.Messages;
import com.project.hms.common.utils.PaginationUtils;
import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.PatientDto;
import com.project.hms.service.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@Slf4j
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final String SORT_BY = "updatedAt";
    private static final String SORT_ORDER = "DESC";

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/{doctorId}")
    public ResponseWrapper<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto,@PathVariable Integer doctorId) {
        log.info("inside create patient: controller");
        PatientDto response = patientService.save(patientDto,doctorId);
        return new ResponseWrapper<>(response, Messages.PATIENT_ADDED_SUCCESSFULLY, HttpStatus.CREATED.value());
    }

    @PutMapping("/update/{id}")
    public ResponseWrapper<PatientDto> updatePatient(@Valid @RequestBody PatientDto patientDto,@PathVariable Integer id) {
        log.info("inside update patient: controller");
        PatientDto response = patientService.update(patientDto,id);
        return new ResponseWrapper<>(response,Messages.PATIENT_UPDATED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @GetMapping("/retrieve/{id}")
    public ResponseWrapper<PatientDto> getPatient(@PathVariable Integer id) {
        log.info("inside get patient by id: controller");
        PatientDto response = patientService.getById(id);
        return new ResponseWrapper<>(response,Messages.PATIENT_RETRIEVED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<PatientDto>> getPatients(){
        log.info("get all patients : controller");
        List<PatientDto> response = patientService.getAll();
        return new ResponseWrapper<>(response,Messages.PATIENT_RETRIEVED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deletePatient(@PathVariable Integer id) {
        log.info("inside delete patient: controller");
        patientService.delete(id);
        return new ResponseWrapper<>(null,Messages.PATIENT_DELETED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @GetMapping("/search")
    public ResponseWrapper<Object> searchPatient(@RequestParam("query")Optional<String> query,
                                                           @RequestParam("page")Optional<Integer> page,
                                                           @RequestParam("size")Optional<Integer> size,
                                                           @RequestParam("sortBy")Optional<String> sortBy,
                                                           @RequestParam("sortOrder")Optional<String> sortOrder) {
        log.info("inside search patient: controller");
        Pageable pageable = PaginationUtils.preparePagination(
                page,
                size.orElse(DEFAULT_PAGE_SIZE),
                sortBy.orElse(SORT_BY),
                sortOrder.orElse(SORT_ORDER)
        );
        String q;
        Object response;
        if(query.isPresent()){
            q = query.get();
            response = patientService.search(q,pageable);
        }else{
            response = patientService.getAll();
        }
        return new ResponseWrapper<>(response,Messages.PATIENT_RETRIEVED_SUCCESSFULLY,HttpStatus.OK.value());
    }

//    @PutMapping("/approve/{id}")
//    public ResponseWrapper<String> approveAppointment(@PathVariable Integer id) {
//        String response = patientService.approveAppointment(id);
//        return new ResponseWrapper<>(response+" has been approved","approved",HttpStatus.OK.value());
//    }
}
