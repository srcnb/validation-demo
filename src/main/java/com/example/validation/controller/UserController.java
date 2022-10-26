package com.example.validation.controller;

import javax.validation.Valid;

import com.example.validation.dto.UserDTO;
import com.example.validation.model.User;
import com.example.validation.service.UserService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@EnableEncryptableProperties
@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){


        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userService.createUser(user);


        UserDTO userResponse = new UserDTO();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());


        return new ResponseEntity<UserDTO>(userResponse, HttpStatus.CREATED);
    }
}
