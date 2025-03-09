package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.DoctorDto;
import com.project.hms.entity.Doctor;
import com.project.hms.mapper.DoctorMapper;
import com.project.hms.repository.DoctorRepo;
import com.project.hms.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private final DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public DoctorDto save(DoctorDto doctorDto) {
        log.info("inside save doctor : service");
        Doctor doctor = DoctorMapper.toEntity(doctorDto);
        doctorRepo.save(doctor);
        return DoctorMapper.toDto(doctor);

    }

    @Override
    public DoctorDto getById(int id) {
        log.info("inside get doctor by id : service");
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        return DoctorMapper.toDto(doctor);
    }

    @Override
    public List<DoctorDto> getAll() {
        log.info("inside get all doctor : service");
        List<Doctor> doctorList = doctorRepo.findAll();
        return doctorList.stream().map(DoctorMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        log.info("inside delete doctor : service");
        Doctor existingDoctor = doctorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        doctorRepo.delete(existingDoctor);

    }
}
