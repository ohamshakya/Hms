package com.project.hms.service;

import com.project.hms.dto.UserDto;

public interface UserService {
    UserDto register(UserDto userDto);

    UserDto verify(UserDto userDto);

    UserDto profile(UserDto userDto);
}
