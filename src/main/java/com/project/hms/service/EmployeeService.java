package com.project.hms.service;

import com.project.hms.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto update(EmployeeDto employeeDto,Integer id);
    EmployeeDto getEmployeeById(Integer id);
    List<EmployeeDto> getAllEmployees();
    void delete(Integer id);
}
