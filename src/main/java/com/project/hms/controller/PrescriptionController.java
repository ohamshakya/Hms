package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.PrescriptionDto;
import com.project.hms.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
@Slf4j
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    public ResponseWrapper<PrescriptionDto> create(PrescriptionDto prescriptionDto) {
        log.info("Inside create prescription : controller");
        PrescriptionDto response = prescriptionService.create(prescriptionDto);
        return new ResponseWrapper<>(response,"prescription added", HttpStatus.CREATED.value());
    }
}
