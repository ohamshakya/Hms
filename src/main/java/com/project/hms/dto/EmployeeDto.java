package com.project.hms.dto;

import com.project.hms.common.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

    private Integer id;

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotEmpty(message = "salary is mandatory")
    private Double salary;

    private Gender gender;

    private String mobileNumber;

    private String state;

    private String city;

    private String pinNumber;
}
