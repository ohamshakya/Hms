package com.project.hms.mapper;

import com.project.hms.dto.EmployeeDto;
import com.project.hms.entity.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setGender(employeeDto.getGender());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setState(employeeDto.getState());
        employee.setCity(employeeDto.getCity());
        employee.setPinNumber(employeeDto.getPinNumber());
        return employee;
    }

    public static EmployeeDto toDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setGender(employee.getGender());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        employeeDto.setState(employee.getState());
        employeeDto.setCity(employee.getCity());
        employeeDto.setPinNumber(employee.getPinNumber());
        return employeeDto;
    }
}
