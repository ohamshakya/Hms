package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.hms.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillDto {

    @JsonIgnore
    private Integer id;

    private float totalAmount;

    @CreationTimestamp
    private LocalDate date;

    private PatientDto patient;
}
