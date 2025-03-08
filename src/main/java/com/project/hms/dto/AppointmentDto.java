package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.hms.common.enums.Status;
import com.project.hms.entity.Doctor;
import com.project.hms.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDto {

    @JsonIgnore
    private Integer id;

    private LocalDate appointmentDate;

    private Status status;

    @JsonIgnore
    private Patient patient;

    @JsonIgnore
    private Doctor doctor;
}
