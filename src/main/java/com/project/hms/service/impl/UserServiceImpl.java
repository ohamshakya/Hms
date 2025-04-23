package com.project.hms.service.impl;

import com.project.hms.common.exception.AlreadyExistsException;
import com.project.hms.dto.UserDto;
import com.project.hms.entity.User;
import com.project.hms.mapper.UserMapper;
import com.project.hms.repository.UsersRepo;
import com.project.hms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepo usersRepo;

    public UserServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDto register(UserDto userDto) {
        User existedUser = usersRepo.findByUsername(userDto.getUsername());
        if (existedUser != null) {
            throw new AlreadyExistsException("User already exists");
        }
        User userData = UserMapper.toEntity(userDto);
        usersRepo.save(userData);
        return UserMapper.toDto(userData);
    }

    @Override
    public UserDto verify(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto profile(UserDto userDto) {
        return null;
    }
}
