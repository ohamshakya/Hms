package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.RoomDto;
import com.project.hms.entity.Room;
import com.project.hms.mapper.RoomMapper;
import com.project.hms.repository.RoomRepo;
import com.project.hms.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public RoomDto add(RoomDto roomDto) {
        Room room = RoomMapper.toEntity(roomDto);
        roomRepo.save(room);
        return RoomMapper.toDto(room);
    }

    @Override
    public RoomDto update(RoomDto roomDto, Integer id) {
        Room existingRoom   = roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        existingRoom.setRoomNumber(roomDto.getRoomNumber());
        existingRoom.setRoomType(roomDto.getRoomType());
        existingRoom.setRoomAvailability(roomDto.getRoomAvailability());
        roomRepo.save(existingRoom);
        return RoomMapper.toDto(existingRoom);
    }

    @Override
    public RoomDto getById(Integer id) {
        Room existingRoom = roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        return RoomMapper.toDto(existingRoom);
    }

    @Override
    public List<RoomDto> getAll() {
        List<Room> rooms = roomRepo.findAll();
        return rooms.stream().map(RoomMapper::toDto).collect(Collectors.toList());
    }
}
