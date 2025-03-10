package com.project.hms.dto;

import com.project.hms.common.enums.RoomAvailability;
import com.project.hms.common.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {
    private Integer id;

    private String roomNumber;

    private RoomType roomType;

    private RoomAvailability roomAvailability;
}
