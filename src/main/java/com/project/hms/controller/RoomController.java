package com.project.hms.controller;

import com.project.hms.common.utils.Messages;
import com.project.hms.common.utils.PaginationUtils;
import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.RoomDto;
import com.project.hms.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;

    public static final int DEFAULT_PAGE = 10;
    public static final String SORT_BY = "updatedAt";
    public static final String SORT_ORDER = "DESC";


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseWrapper<RoomDto> addRoom(@Valid @RequestBody RoomDto roomDto) {
        RoomDto response = roomService.add(roomDto);
        return new ResponseWrapper<>(response, Messages.ROOM_ADDED_SUCCESSFULLY, HttpStatus.CREATED.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<RoomDto> updateRoom(@PathVariable int id, @Valid @RequestBody RoomDto roomDto) {
        RoomDto response = roomService.update(roomDto, id);
        return new ResponseWrapper<>(response, Messages.ROOM_UPDATED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping("{id}")
    public ResponseWrapper<RoomDto> getRoom(@PathVariable int id) {
        RoomDto response = roomService.getById(id);
        return new ResponseWrapper<>(response, Messages.ROOM_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping
    public ResponseWrapper<List<RoomDto>> getRooms() {
        List<RoomDto> response = roomService.getAll();
        return new ResponseWrapper<>(response, Messages.ROOM_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @GetMapping("/search")
    public ResponseWrapper<Object> search(@RequestParam("query") Optional<String> query,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size,
                                          @RequestParam("sortBy") Optional<String> sortBy,
                                          @RequestParam("sortOrder") Optional<String> sortOrder) {
        Pageable pageable = PaginationUtils.preparePagination(
                page,
                size.orElse(DEFAULT_PAGE),
                sortBy.orElse(SORT_BY),
                sortOrder.orElse(SORT_ORDER)
        );
        String q;
        Object response;

        if (query.isPresent()) {
            q = query.get();
            response = roomService.search(q, pageable);
        } else {
            response = roomService.getAll();
        }
        return new ResponseWrapper<>(response, Messages.ROOM_RETRIEVED_SUCCESSFULLY, HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Object> deleteRoom(@PathVariable int id) {
        roomService.deleteById(id);
        return new ResponseWrapper<>(null, Messages.ROOM_DELETED_SUCCESSFULLY, HttpStatus.OK.value());
    }
}
