package com.project.hms.mapper;

import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setDob(patientDto.getDob());
        patient.setGender(patientDto.getGender());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setAge(patientDto.getAge());
        return patient;
    }

    public static PatientDto toDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setDob(patient.getDob());
        patientDto.setGender(patient.getGender());
        patientDto.setMobileNumber(patient.getMobileNumber());
        patientDto.setAge(patient.getAge());
        return patientDto;
    }

}
