package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.PrescriptionDto;
import com.project.hms.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
@Slf4j
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseWrapper<PrescriptionDto> create(@RequestBody PrescriptionDto prescriptionDto) {
        log.info("Inside create prescription : controller");
        PrescriptionDto response = prescriptionService.create(prescriptionDto);
        return new ResponseWrapper<>(response,"prescription added", HttpStatus.CREATED.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<PrescriptionDto> update(@RequestBody PrescriptionDto prescriptionDto,@PathVariable Integer id){
        log.info("Inside update prescription : controller");
        PrescriptionDto updateResponse = prescriptionService.update(id, prescriptionDto);
        return new ResponseWrapper<>(updateResponse,"prescription updated", HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<PrescriptionDto> getById(@PathVariable Integer id){
        log.info("Inside get prescription : controller");
        PrescriptionDto response = prescriptionService.getById(id);
        return new ResponseWrapper<>(response,"prescription retrieved", HttpStatus.OK.value());
    }
}
