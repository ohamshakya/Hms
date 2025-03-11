package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.RoomDto;
import com.project.hms.entity.Room;
import com.project.hms.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
