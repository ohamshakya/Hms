package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.common.utils.Messages;
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

    private final AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        log.info("inside save appointment : service");
        Appointment appointment = AppointmentMapper.toEntity(null,appointmentDto);
        appointmentRepo.save(appointment);
        return AppointmentMapper.toDto(appointment);
    }

    @Override
    public AppointmentDto update(Integer id, AppointmentDto appointmentDto) {
        Appointment existingAppointment = appointmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.APPOINTMENT_NOT_FOUND));
        Appointment response = AppointmentMapper.toEntity(existingAppointment,appointmentDto);
        appointmentRepo.save(response);
        return AppointmentMapper.toDto(response);
    }

    @Override
    public AppointmentDto getById(Integer id) {
        log.info("inside get appointment by id : service");
        Appointment existing = appointmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.APPOINTMENT_NOT_FOUND));
        return AppointmentMapper.toDto(existing);
    }

    @Override
    public List<AppointmentDto> getAllAppointment() {
        log.info("inside get all appointment : service");
        List<Appointment> allAppointment = appointmentRepo.findAll();
        return allAppointment.stream().map(AppointmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> findByAppointmentDate(LocalDate appointmentDate) {
        log.info("inside find by appointment date : service");
        List<Patient> patientList = appointmentRepo.findPatientByAppointmentDate(appointmentDate);
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

}
