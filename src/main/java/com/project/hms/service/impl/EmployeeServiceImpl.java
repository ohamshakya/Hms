package com.project.hms.service.impl;

import com.project.hms.dto.EmployeeDto;
import com.project.hms.entity.Employee;
import com.project.hms.mapper.EmployeeMapper;
import com.project.hms.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        log.info("inside employee save : service");
        Employee employee = EmployeeMapper.toEntity(employeeDto);

    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, Integer id) {
        return null;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}
