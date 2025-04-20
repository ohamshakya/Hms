package com.project.hms.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
