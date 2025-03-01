package com.project.hms.repository;

import com.project.hms.common.enums.Gender;
import com.project.hms.entity.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PatientRepoTest {

    @Autowired
    private PatientRepo patientRepo;

    Patient patient;

    @BeforeEach
    void setUp(){
        patient = new Patient(1,"Emily Clark", LocalDate.of(2025,02,03), Gender.FEMALE,"+1122334455",32);
        patientRepo.save(patient);
    }

    @AfterEach
    void tearDown(){
        patient = null;
        patientRepo.deleteAll();

    }

    /// Test case for SUCCESS
    @Test
    void testFoundByPatientName_SUCCESS(){
        Patient name = patientRepo.findByName("Emily Clark");
        assertThat(name.getName()).isEqualTo(patient.getName());
    }



    /// Test case for FAILURE
}
