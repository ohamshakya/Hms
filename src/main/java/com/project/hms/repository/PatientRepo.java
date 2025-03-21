package com.project.hms.repository;

import com.project.hms.entity.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
    Patient findByName(String name);

    @Query("SELECT p FROM Patient p WHERE (:searchTerm IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Patient> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}
