package com.project.hms.service.impl;

import com.project.hms.dto.AppointmentDto;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Appointment;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.AppointmentMapper;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.AppointmentRepo;
import com.project.hms.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private final AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        log.info("inside save appointment : service");
        Appointment appointment = AppointmentMapper.toEntity(appointmentDto);
        appointmentRepo.save(appointment);
        return AppointmentMapper.toDto(appointment);
    }

    @Override
    public List<PatientDto> findByAppointmentDate(LocalDate appointmentDate) {
        log.info("inside find by appointment date : service");
        List<Patient> patientList = appointmentRepo.findPatientByAppointmentDate(appointmentDate);
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

}
