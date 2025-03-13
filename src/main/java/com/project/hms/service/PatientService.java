package com.project.hms.service;

import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;

import java.util.List;

public interface PatientService {
    PatientDto save(PatientDto patientDto);

    PatientDto update(PatientDto patientDto,Integer id);

    PatientDto getById(Integer id);

    List<PatientDto> getAll();

    void delete(Integer id);

    List<PatientDto> search(String query);

//    String approveAppointment(Integer id);

    Patient checkIfExist(Integer id);

}
