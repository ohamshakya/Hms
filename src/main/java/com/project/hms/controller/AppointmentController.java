package com.project.hms.controller;

import com.project.hms.common.utils.Messages;
import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.AppointmentDto;
import com.project.hms.dto.PatientDto;
import com.project.hms.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@Slf4j
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseWrapper<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        log.info("inside create appointment : controller");
        AppointmentDto response = appointmentService.save(appointmentDto);
        return new ResponseWrapper<>(response, Messages.APPOINTMENT_ADDED_SUCCESSFULLY,HttpStatus.CREATED.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<AppointmentDto> updateAppointment(@PathVariable int id, @RequestBody AppointmentDto appointmentDto) {
        log.info("inside update appointment : controller");
        AppointmentDto response = appointmentService.update(id, appointmentDto);
        return new ResponseWrapper<>(response,Messages.APPOINTMENT_UPDATED_SUCCESSFULLY,HttpStatus.OK.value());
    }

    @GetMapping("/search")
    public ResponseWrapper<List<PatientDto>> search(@RequestParam LocalDate appointmentDate){
        List<PatientDto> response = appointmentService.findByAppointmentDate(appointmentDate);
        return new ResponseWrapper<>(response,"retrieved successfully", HttpStatus.OK.value());
    }
}
