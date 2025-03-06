package com.project.hms.repository;

import com.project.hms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    List<Department> searchDepartmentByName(String name);

}
