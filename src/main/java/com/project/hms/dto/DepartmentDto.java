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
public class DepartmentDto {

    @JsonIgnore
    private Integer id;

    private String name;

    private List<DoctorDto> doctorDtoList;
}
