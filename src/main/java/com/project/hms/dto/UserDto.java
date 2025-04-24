package com.project.hms.dto;

import com.project.hms.common.enums.UserStatus;
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

    private UserStatus userStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
