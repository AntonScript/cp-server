package com.example.cpserver.controller.user;


import com.example.cpserver.controller.dto.Message;
import com.example.cpserver.controller.dto.Token;
import com.example.cpserver.controller.user.dto.AuthUserDto;
import com.example.cpserver.controller.user.dto.RegUserDto;
import com.example.cpserver.model.User;
import com.example.cpserver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public Message registration(
            @Valid @RequestBody RegUserDto userDto
    ){

        return userService.regUser(new User(userDto));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Token loginUser(@RequestBody AuthUserDto userDto){
        return userService.logUser(userDto);
    }

}
