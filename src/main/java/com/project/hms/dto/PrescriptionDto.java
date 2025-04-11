package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PrescriptionDto {
    private Integer id;

    private String medicineName;

    private String dosage;

    private LocalDate prescriptionDate;

    @JsonIgnore
    private DoctorDto doctorDto;
}
