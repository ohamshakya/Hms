package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDto {

    @JsonIgnore
    private Integer id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "speciality is required")
    private String speciality;

    @NotBlank(message = "contact number is required")
    private String contactNumber;

    private List<AppointmentDto> appointmentDtoList;

    @JsonIgnore
    private DepartmentDto department;
}
