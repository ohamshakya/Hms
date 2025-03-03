package com.project.hms.service.impl;

import com.project.hms.common.enums.Gender;
import com.project.hms.entity.Patient;
import com.project.hms.repository.PatientRepo;
import com.project.hms.service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;


class PatientServiceImplTest {

    //don't look for database duplicate repo
    @Mock
    private PatientRepo patientRepo;
    private  PatientService patientService;
    // close all the  resources class after execution is completed
    AutoCloseable autoCloseable;
    Patient patient;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        patientService = new PatientServiceImpl(patientRepo);
        patient = new Patient(null,"John", LocalDate.of(2025,1,2), Gender.MALE,"9809098101",40);
    }

    @AfterEach
    void tearDown()throws Exception {
        autoCloseable.close();
    }

    @Test
    void save() {

    }

    @Test
    void update() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }
}