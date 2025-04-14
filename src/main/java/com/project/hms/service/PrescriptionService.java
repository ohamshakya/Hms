package com.project.hms.service;

import com.project.hms.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {
    PrescriptionDto create(PrescriptionDto prescriptionDto);

    PrescriptionDto update(Integer id, PrescriptionDto prescriptionDto);

    PrescriptionDto getById(Integer id);

    String delete(Integer id);

    List<PrescriptionDto> getAllPrescription();
}
