package com.project.hms.service;

import com.project.hms.dto.RoomDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    RoomDto add(RoomDto roomDto);

    RoomDto update(RoomDto roomDto,Integer id);

    RoomDto getById(Integer id);

    List<RoomDto> getAll();

    Page<RoomDto> search(String query,Pageable pageable);

    void deleteById(Integer id);
}
