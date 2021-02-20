package com.example.micro.smlr.services.dto;

import com.example.micro.smlr.mappers.UserMapper;
import com.example.micro.smlr.models.dto.UserDto;
import com.example.micro.smlr.services.entity.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoServiceImpl implements UserDtoService {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserDtoServiceImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
       return userService.getAllUsers().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
