package com.project.hms.repository;

import com.project.hms.entity.Appointment;
import com.project.hms.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.time.LocalDate;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

//    @Query("SELECT a.patient FROM Appointment a WHERE a.appointmentDate = :appointmentDate")
    List<Patient> findPatientByAppointmentDate(@Param("appointmentDate")LocalDate appointmentDate);

//    Page<Appointment> getPatientInPage(Pageable pageable);
}
