package com.project.hms.service.impl;

import com.project.hms.dto.DepartmentDto;
import com.project.hms.entity.Department;
import com.project.hms.mapper.DepartmentMapper;
import com.project.hms.repository.DepartmentRepo;
import com.project.hms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public DepartmentDto getById(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public DepartmentDto delete(Integer id) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return List.of();
    }
}
