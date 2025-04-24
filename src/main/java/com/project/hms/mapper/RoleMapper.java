package com.project.hms.mapper;

import com.project.hms.dto.RoleDto;
import com.project.hms.entity.Role;

public class RoleMapper {
    public static Role toEntity(RoleDto roleDto){
        return Role.builder()
                .name(roleDto.getName())
                .users(roleDto.getUsers())
                .build();
    }

    public static RoleDto toDto(Role role){
        return RoleDto.builder()
                .name(role.getName())
                .users(role.getUsers())
                .build();
    }
}
