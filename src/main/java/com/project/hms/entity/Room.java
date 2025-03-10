package com.project.hms.entity;

import com.project.hms.common.enums.RoomAvailability;
import com.project.hms.common.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "room_details")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private RoomAvailability roomAvailability;

}
