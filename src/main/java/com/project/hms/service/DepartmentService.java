package com.project.hms.service;

import com.project.hms.dto.DepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto);

    DepartmentDto update(DepartmentDto departmentDto,Integer id);

    DepartmentDto getById(Integer id);

    void delete(Integer id);

    List<DepartmentDto> getAll();

    Page<DepartmentDto> search(String query, Pageable pageable);
}
