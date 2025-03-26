package com.project.hms.repository;

import com.project.hms.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d WHERE (:searchTerm IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    Page<Doctor> searchDoctor(@Param("query") String query, Pageable pageable);
}
