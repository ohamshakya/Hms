package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.DepartmentDto;
import com.project.hms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseWrapper<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        log.info("inside save department : controller");
        DepartmentDto response = departmentService.save(departmentDto);
        return new ResponseWrapper<>(response,"created successfully", HttpStatus.CREATED.value());
    }

    @PutMapping("/update/{id}")
    public ResponseWrapper<DepartmentDto> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        log.info("inside update department : controller");
        DepartmentDto updateResponse = departmentService.update(departmentDto, id);
        return new ResponseWrapper<>(updateResponse,"updated successfully", HttpStatus.OK.value());
    }

    @GetMapping("/get/{id}")
    public ResponseWrapper<DepartmentDto> getDepartment(@PathVariable Integer id) {
        log.info("inside get department by id : controller");
        DepartmentDto response = departmentService.getById(id);
        return new ResponseWrapper<>(response,"get successfully", HttpStatus.OK.value());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseWrapper<Object> deleteDepartment(@PathVariable Integer id) {
        log.info("inside delete department : controller");
        departmentService.delete(id);
        return new ResponseWrapper<>(null,"deleted successfully", HttpStatus.OK.value());
    }

    @GetMapping
    public  ResponseWrapper<List<DepartmentDto>> getAllDepartment() {
        log.info("inside get all department : controller");
        List<DepartmentDto> response = departmentService.getAll();
        return new ResponseWrapper<>(response,"retrieved successfully", HttpStatus.OK.value());
    }
}
