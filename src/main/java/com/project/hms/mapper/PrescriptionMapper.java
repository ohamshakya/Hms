package com.project.hms.mapper;

import com.project.hms.dto.PrescriptionDto;
import com.project.hms.entity.Prescription;

public class PrescriptionMapper {
    public static Prescription toEntity(Prescription existing,PrescriptionDto prescriptionDto) {
        if(existing != null) {
            existing.setPrescriptionDate(prescriptionDto.getPrescriptionDate());
            existing.setDosage(prescriptionDto.getDosage());
            existing.setMedicineName(prescriptionDto.getMedicineName());
            return existing;
        }
        return Prescription.builder()
                .dosage(prescriptionDto.getDosage())
                .prescriptionDate(prescriptionDto.getPrescriptionDate())
                .medicineName(prescriptionDto.getMedicineName())
                .build();
    }

    public static PrescriptionDto toDto(Prescription prescription) {
        return PrescriptionDto.builder()
                .prescriptionDate(prescription.getPrescriptionDate())
                .medicineName(prescription.getMedicineName())
                .dosage(prescription.getDosage())
                .build();
    }
}
