package com.project.hms.service;

import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    PatientDto save(PatientDto patientDto,Integer id);

    PatientDto update(PatientDto patientDto,Integer id);

    PatientDto getById(Integer id);

    List<PatientDto> getAll();

    void delete(Integer id);

    List<PatientDto> search(String query, Pageable pageable);

//    String approveAppointment(Integer id);

    Patient checkIfExist(Integer id);

}
