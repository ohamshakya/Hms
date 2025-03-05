package com.project.hms.dto;

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
    private Integer id;

    private String name;

    private String speciality;

    private String contactNumber;

    private DepartmentDto department;
}
