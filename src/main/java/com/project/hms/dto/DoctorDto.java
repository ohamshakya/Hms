package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String name;

    private String speciality;

    private String contactNumber;

    private List<AppointmentDto> appointmentDtoList;

    @JsonIgnore
    private DepartmentDto department;
}
