package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.PrescriptionDto;
import com.project.hms.entity.Prescription;
import com.project.hms.mapper.PrescriptionMapper;
import com.project.hms.repository.PrescriptionRepo;
import com.project.hms.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;

    public PrescriptionServiceImpl(PrescriptionRepo prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    @Override
    public PrescriptionDto create(PrescriptionDto prescriptionDto) {
        log.info("inside create prescription : service");
        Prescription prescription = PrescriptionMapper.toEntity(null, prescriptionDto);
        Prescription prescriptionSave = prescriptionRepo.save(prescription);
        return PrescriptionMapper.toDto(prescriptionSave);
    }

    @Override
    public PrescriptionDto update(Integer id, PrescriptionDto prescriptionDto) {
        log.info("inside update prescription : service");
        Prescription prescription = prescriptionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        Prescription prescriptionCheck = PrescriptionMapper.toEntity(prescription, prescriptionDto);
        Prescription prescriptionUpdate = prescriptionRepo.save(prescriptionCheck);
        return PrescriptionMapper.toDto(prescriptionUpdate);
    }

    @Override
    public PrescriptionDto getById(Integer id) {
        log.info("inside get prescription : service");
        Prescription prescription = prescriptionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        return PrescriptionMapper.toDto(prescription);
    }

    @Override
    public String delete(Integer id) {
        log.info("inside delete prescription : service");
        Prescription existingPrescription = prescriptionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        prescriptionRepo.delete(existingPrescription);
        return "prescription deleted ";
    }

    @Override
    public List<PrescriptionDto> getAllPrescription() {
        log.info("inside get all prescription : service");
        List<Prescription> prescriptionList = prescriptionRepo.findAll();
        return prescriptionList.stream().map(PrescriptionMapper::toDto).collect(Collectors.toList());
    }
}
