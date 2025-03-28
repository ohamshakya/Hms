package com.project.hms.controller;

import com.project.hms.common.utils.Messages;
import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.DoctorDto;
import com.project.hms.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {
    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseWrapper<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        log.info("inside create doctor : controller");
        DoctorDto response = doctorService.save(doctorDto);
        return new ResponseWrapper<>(response, Messages.DOCTOR_ADDED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<DoctorDto> getDoctorById(@PathVariable int id) {
        log.info("inside get doctor by id : controller");
        DoctorDto response = doctorService.getById(id);
        return new ResponseWrapper<>(response,Messages.DOCTOR_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<DoctorDto>> getAllDoctors() {
        log.info("get all doctor : controller");
        List<DoctorDto> response = doctorService.getAll();
        return new ResponseWrapper<>(response,Messages.DOCTOR_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> delete(@PathVariable Integer id){
        log.info("inside delete doctor : controller");
        doctorService.deleteById(id);
        return new ResponseWrapper<>(null,Messages.DOCTOR_DELETED_SUCCESSFULLY, HttpStatus.OK.value());
    }
}
