package com.project.hms.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    void tearDown() throws Exception {
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