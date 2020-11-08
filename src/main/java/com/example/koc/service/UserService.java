package com.example.koc.service;

import com.example.koc.dto.UserDto;
import com.example.koc.entity.User;
import com.example.koc.shared.GenericResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    GenericResponse saveUser(UserDto userDto);
    GenericResponse getUserById(Long id);
}
