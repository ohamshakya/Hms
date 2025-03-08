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

//    @Autowired
//    private PatientRepo patientRepo;
//    Patient patient;

    @BeforeEach
    void setUp(){
//        patient = new Patient(null,"John", LocalDate.of(2025,1,2), Gender.MALE,"9809098101",40);
//        patientRepo.save(patient);
    }

    @AfterEach
    void tearDown(){
//        patient = null;
//        patientRepo.deleteAll();
    }

    //test for success
    @Test
    void findByPatientNameSuccess(){
//        Patient found = patientRepo.findByName("John");
//        assertThat(found.getName()).isEqualTo(patient.getName());
    }

    //test fo failure
    @Test
    void findByPatientNameFail(){
//        Patient found = patientRepo.findByName("Smith");
//        assertThat(found).isNull();
    }
}
