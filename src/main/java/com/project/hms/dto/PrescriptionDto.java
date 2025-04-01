package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrescriptionDto {
    private Integer id;

    private String medicineName;

    private String dosage;

    private LocalDate prescriptionDate;

    @JsonIgnore
    private DoctorDto doctorDto;
}
