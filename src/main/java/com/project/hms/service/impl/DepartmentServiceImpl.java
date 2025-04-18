package com.project.hms.service.impl;

import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.common.utils.Messages;
import com.project.hms.dto.DepartmentDto;
import com.project.hms.entity.Department;
import com.project.hms.mapper.DepartmentMapper;
import com.project.hms.repository.DepartmentRepo;
import com.project.hms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        log.info("inside department save : service");
        Department department = DepartmentMapper.toEntity(departmentDto);
        departmentRepo.save(department);
        return DepartmentMapper.toDto(department);
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto, Integer id) {
        log.info("inside department update : service");

        Department existingDepartment = departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.DEPARTMENT_NOT_FOUND));
        DepartmentMapper.toUpdate(existingDepartment,departmentDto,id);
        Department result = departmentRepo.save(existingDepartment);
        return DepartmentMapper.toDto(result);
    }

    @Override
    public DepartmentDto getById(Integer id) {
        log.info("inside department getById : service");
        Department existingDepartment = departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.DEPARTMENT_NOT_FOUND));
        return DepartmentMapper.toDto(existingDepartment);
    }

    @Override
    public void delete(Integer id) {
        log.info("inside department delete : service");
        Department deleteDepartment = departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.DEPARTMENT_NOT_FOUND));
        departmentRepo.delete(deleteDepartment);
    }

    @Override
    public List<DepartmentDto> getAll() {
        log.info("inside department getAll : service");
        List<Department> departments = departmentRepo.findAll();
        return departments.stream().map(DepartmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<DepartmentDto> search(String query, Pageable pageable) {
        log.info("inside search department : service");
       return departmentRepo.searchDepartmentByName(query,pageable).map(DepartmentMapper::toDto);
    }
}
