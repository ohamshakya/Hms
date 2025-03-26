package com.project.hms.service;

import com.project.hms.dto.DoctorDto;
import com.project.hms.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DoctorService {
    DoctorDto save(DoctorDto doctorDto);

    DoctorDto getById(int id);

    List<DoctorDto> getAll();

    void deleteById(int id);

    Page<DoctorDto> searchDoctorByName(String query, Pageable pageable);

}
