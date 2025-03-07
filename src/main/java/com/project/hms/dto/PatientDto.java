package com.project.hms.dto;

import com.project.hms.common.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {

    private Integer id;

    @NotBlank(message = "name is mandatory")
    private String name;

    private LocalDate dob;

    private Gender gender;

    @NotBlank(message = "mobile_number is mandatory")
    private String mobileNumber;

    private Integer age;
}
