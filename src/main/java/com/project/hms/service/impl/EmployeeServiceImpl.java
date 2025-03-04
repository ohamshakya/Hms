package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.dto.EmployeeDto;
import com.project.hms.entity.Employee;
import com.project.hms.mapper.EmployeeMapper;
import com.project.hms.repository.EmployeeRepo;
import com.project.hms.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        log.info("inside employee save : service");
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        employeeRepo.save(employee);
        return EmployeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, Integer id) {
        log.info("inside employee update : service");
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setSalary(employeeDto.getSalary());
        existingEmployee.setGender(employeeDto.getGender());
        existingEmployee.setMobileNumber(employeeDto.getMobileNumber());
        existingEmployee.setState(employeeDto.getState());
        existingEmployee.setCity(employeeDto.getCity());
        existingEmployee.setPinNumber(employeeDto.getPinNumber());
        employeeRepo.save(existingEmployee);
        return EmployeeMapper.toDto(existingEmployee);
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
