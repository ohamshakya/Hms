package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.PatientRepo;
import com.project.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = PatientMapper.toEntity(patientDto);
        patientRepo.save(patient);
        return PatientMapper.toDto(patient);
    }

    @Override
    public PatientDto update(PatientDto patientDto, Integer id) {
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        existingPatient.setName(patientDto.getName());
        existingPatient.setDob(patientDto.getDob());
        existingPatient.setGender(patientDto.getGender());
        existingPatient.setMobileNumber(patientDto.getMobileNumber());
        existingPatient.setAge(patientDto.getAge());
        patientRepo.save(existingPatient);
        return PatientMapper.toDto(existingPatient);
    }

    @Override
    public PatientDto getById(Integer id) {
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return PatientMapper.toDto(existingPatient);
    }

    @Override
    public List<PatientDto> getAll() {
        List<Patient> patientList = patientRepo.findAll();
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        patientRepo.delete(existingPatient);

    }
}
