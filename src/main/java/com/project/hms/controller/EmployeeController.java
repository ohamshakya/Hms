package com.project.hms.controller;

import com.project.hms.common.utils.ResponseWrapper;
import com.project.hms.dto.EmployeeDto;
import com.project.hms.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseWrapper<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("employee create : controller");
        EmployeeDto response = employeeService.save(employeeDto);
        return new ResponseWrapper<>(response, "added successfully", HttpStatus.OK.value());
    }

    @PutMapping("{id}")
    public ResponseWrapper<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable int id) {
        log.info("employee update : controller");
        EmployeeDto response = employeeService.update(employeeDto, id);
        return new ResponseWrapper<>(response, "updated successfully", HttpStatus.OK.value());
    }
}
