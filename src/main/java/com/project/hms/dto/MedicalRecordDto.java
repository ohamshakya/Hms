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
public class MedicalRecordDto {
    private Integer id;

    private String diagnosis;

    private String treatment;

    private LocalDate recordDate;

    @JsonIgnore
    private PatientDto patientDto;
}
