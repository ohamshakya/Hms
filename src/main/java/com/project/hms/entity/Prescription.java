package com.project.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "prescription_details")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String medicineName;

    private String dosage;

    private LocalDate prescriptionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;


}
