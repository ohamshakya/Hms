package com.project.hms.service;

import com.project.hms.dto.PrescriptionDto;

public interface PrescriptionService {
    PrescriptionDto create(PrescriptionDto prescriptionDto);
    PrescriptionDto update(Integer id,PrescriptionDto prescriptionDto);
    PrescriptionDto getById(Integer id);
    void delete(Integer id);
}
