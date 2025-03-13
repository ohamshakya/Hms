package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.hms.common.enums.Gender;
import com.project.hms.entity.Bill;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {
    @JsonIgnore
    private Integer id;

    @NotBlank(message = "name is mandatory")
    private String name;

    private LocalDate dob;

    private Gender gender;

    @NotBlank(message = "mobile_number is mandatory")
    private String mobileNumber;

    private Integer age;

    private List<AppointmentDto> appointmentDtoList;

    private List<BillDto> billDtoList;
}
