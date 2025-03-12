package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.RoomDto;
import com.project.hms.entity.Room;
import com.project.hms.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseWrapper<RoomDto> addRoom(@Valid @RequestBody RoomDto roomDto) {
        RoomDto response = roomService.add(roomDto);
        return new ResponseWrapper<>(response,"created successfully", HttpStatus.CREATED.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<RoomDto> updateRoom(@PathVariable int id, @Valid @RequestBody RoomDto roomDto) {
        RoomDto response = roomService.update(roomDto, id);
        return new ResponseWrapper<>(response,"updated successfully", HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<RoomDto> getRoom(@PathVariable int id) {
        RoomDto response = roomService.getById(id);
        return new ResponseWrapper<>(response,"get successfully", HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<RoomDto>> getRooms() {
        List<RoomDto> response = roomService.getAll();
        return new ResponseWrapper<>(response,"get successfully", HttpStatus.OK.value());
    }
}
