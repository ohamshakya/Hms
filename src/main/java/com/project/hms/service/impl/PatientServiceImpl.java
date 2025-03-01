package com.project.hms.service.impl;

import com.project.hms.common.exception.AlreadyExistsException;
import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.PatientRepo;
import com.project.hms.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        log.info("inside save : service");
        Patient existingPatient = patientRepo.findByName(patientDto.getName());
        if (existingPatient != null) {
            throw new AlreadyExistsException("Patient with name " + patientDto.getName() + " already exists");
        }
        Patient patient = PatientMapper.toEntity(patientDto);
        patientRepo.save(patient);
        return PatientMapper.toDto(patient);
    }

    @Override
    @Transactional
    public PatientDto update(PatientDto patientDto, Integer id) {
        log.info("inside update : service");
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
        log.info("inside getById : service");
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return PatientMapper.toDto(existingPatient);
    }

    @Override
    public List<PatientDto> getAll() {
        log.info("inside getAll : service");
        List<Patient> patientList = patientRepo.findAll();
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("inside delete : service");
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        patientRepo.delete(existingPatient);

    }
}
