package com.project.hms.service.impl;

import com.project.hms.common.enums.Gender;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.PatientRepo;
import com.project.hms.service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class PatientServiceImplTest {

    //don't look for database duplicate repo
//    @Mock
//    private PatientRepo patientRepo;
//    private  PatientService patientService;
//    // close all the  resources class after execution is completed
//    AutoCloseable autoCloseable;
//    PatientDto patientDto;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
//        patientService = new PatientServiceImpl(patientRepo);
//        patientDto  = new PatientDto(null,"John", LocalDate.of(2025,1,2), Gender.MALE,"9809098101",40);
    }

    @AfterEach
    void tearDown()throws Exception {
//        autoCloseable.close();
    }

    @Test
    void testSave() {
//        mock(Patient.class);
//        mock(PatientRepo.class);
//
//        Patient patient = PatientMapper.toEntity(patientDto);
//        when(patientRepo.save(patient)).thenReturn(patient);
//        assertThat(patientService.save(patientDto)).isEqualTo(patientDto);

    }

    @Test
    void testUpdate() {

    }

    @Test
    void testGetById() {
//        mock(Patient.class);
//        mock(PatientRepo.class);
//
//        when(patientRepo.findById(4)).thenThrow(new Exception("not found"));
//        assertThat(patientService.getById(4)).isEqualTo(patientDto.getId());
    }

    @Test
    void testGetAll() {
    }

    @Test
    void testDelete() {
    }
}