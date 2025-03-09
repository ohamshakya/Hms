package com.project.hms.mapper;

import com.project.hms.dto.DoctorDto;
import com.project.hms.entity.Doctor;

public class DoctorMapper {
    public static Doctor toEntity(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpeciality(doctorDto.getSpeciality());
        doctor.setContactNumber(doctorDto.getContactNumber());
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
