package com.project.hms.service;

import com.project.hms.dto.PatientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<PatientDto> findByAppointmentDate(LocalDate appointmentDate);

}
