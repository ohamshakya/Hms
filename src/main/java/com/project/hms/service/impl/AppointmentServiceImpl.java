package com.project.hms.service.impl;

import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.AppointmentRepo;
import com.project.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private final AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public List<PatientDto> findByAppointmentDate(LocalDate appointmentDate) {
        List<Patient> patientList = appointmentRepo.findPatientByAppointmentDate(appointmentDate);
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }
}
