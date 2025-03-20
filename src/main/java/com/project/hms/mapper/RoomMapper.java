package com.project.hms.mapper;

import com.project.hms.dto.RoomDto;
import com.project.hms.entity.Room;

public class RoomMapper {
    public static Room toEntity(RoomDto roomDto) {
        return Room.builder()
                .roomNumber(roomDto.getRoomNumber())
                .roomType(roomDto.getRoomType())
                .roomAvailability(roomDto.getRoomAvailability())
                .build();

    }

    public static RoomDto toDto(Room room) {
        return RoomDto.builder()
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .roomAvailability(room.getRoomAvailability())
                .build();
    }
}
