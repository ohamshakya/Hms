package com.project.hms.repository;

import com.project.hms.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r where LOWER(r.roomNumber) LIKE LOWER(CONCAT('%', :query, '%'))OR LOWER(r.roomNumber) LIKE LOWER(CONCAT('%', :query, '%') ) ")
    Page<Room> search(@Param("query") String query, Pageable pageable);
}
