package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.hms.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JsonIgnore
    private DepartmentDto department;
}
