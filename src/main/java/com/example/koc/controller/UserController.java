package com.example.koc.controller;

import com.example.koc.dto.UserDto;
import com.example.koc.entity.User;
import com.example.koc.serviceImpl.UserServiceImpl;
import com.example.koc.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/users")
    public GenericResponse saveUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public GenericResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


}
