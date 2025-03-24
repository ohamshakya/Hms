package com.project.hms.repository;

import com.project.hms.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @Query("SELECT d FROM Department d WHERE (:searchTerm IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    Page<Department> searchDepartmentByName(@Param("searchTerm") String name, Pageable pageable);
}
