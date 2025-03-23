package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.RoomDto;
import com.project.hms.entity.Room;
import com.project.hms.mapper.RoomMapper;
import com.project.hms.repository.RoomRepo;
import com.project.hms.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public RoomDto add(RoomDto roomDto) {
        log.info("inside create room : service");
        Room room = RoomMapper.toEntity(roomDto);
        roomRepo.save(room);
        return RoomMapper.toDto(room);
    }

    @Override
    public RoomDto update(RoomDto roomDto, Integer id) {
        log.info("inside update room : service");
        Room existingRoom   = roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        existingRoom.setRoomNumber(roomDto.getRoomNumber());
        existingRoom.setRoomType(roomDto.getRoomType());
        existingRoom.setRoomAvailability(roomDto.getRoomAvailability());
        roomRepo.save(existingRoom);
        return RoomMapper.toDto(existingRoom);

    }

    @Override
    public RoomDto getById(Integer id) {
        log.info("inside get by id room : service");
        Room existingRoom = roomRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
        return RoomMapper.toDto(existingRoom);
    }

    @Override
    public List<RoomDto> getAll() {
        log.info("inside get all room : service");
        List<Room> rooms = roomRepo.findAll();
        return rooms.stream().map(RoomMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<RoomDto> search(String query,Pageable pageable) {
        log.info("inside search room : service");
        return roomRepo.search(query,pageable).map(RoomMapper::toDto);
    }
}
