package com.project.hms.service;

import com.project.hms.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto add(RoomDto roomDto);

    RoomDto update(RoomDto roomDto,Integer id);

    RoomDto getById(Integer id);

    List<RoomDto> getAll();
}
