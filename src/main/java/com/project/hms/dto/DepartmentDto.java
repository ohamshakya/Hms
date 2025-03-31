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
public class DepartmentDto {

    @JsonIgnore
    private Integer id;

    @NotBlank(message = "name is required")
    private String name;

    private List<DoctorDto> doctorDtoList;
}
