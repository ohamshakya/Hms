package com.project.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String userStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
