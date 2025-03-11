package com.project.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.hms.common.enums.RoomAvailability;
import com.project.hms.common.enums.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomDto {
    @JsonIgnore
    private Integer id;

    @NotBlank(message = "room number is required")
    private String roomNumber;

    private RoomType roomType;

    private RoomAvailability roomAvailability;
}
