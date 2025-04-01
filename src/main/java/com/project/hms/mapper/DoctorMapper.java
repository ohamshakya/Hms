package com.project.hms.mapper;

import com.project.hms.dto.DoctorDto;
import com.project.hms.dto.PrescriptionDto;
import com.project.hms.entity.Doctor;
import com.project.hms.entity.MedicalRecord;
import com.project.hms.entity.Prescription;

import java.util.ArrayList;
import java.util.List;

public class DoctorMapper {
    public static Doctor toEntity(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpeciality(doctorDto.getSpeciality());
        doctor.setContactNumber(doctorDto.getContactNumber());
        List<Prescription> prescriptionsList = new ArrayList<>();
       if(doctorDto.getPrescriptionDtoList() != null){
           for(PrescriptionDto prescriptionDto: doctorDto.getPrescriptionDtoList()){
               Prescription prescription = new Prescription();
               prescription.setMedicineName(prescriptionDto.getMedicineName());
               prescription.setDosage(prescriptionDto.getDosage());
               prescription.setPrescriptionDate(prescriptionDto.getPrescriptionDate());
               prescription.setDoctor(doctor);
               prescriptionsList.add(prescription);
           }
       }
       doctor.setPrescriptionsList(prescriptionsList);
        return doctor;
    }

    public static DoctorDto toDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setName(doctor.getName());
        doctorDto.setSpeciality(doctor.getSpeciality());
        doctorDto.setContactNumber(doctor.getContactNumber());
        return doctorDto;
    }
}
