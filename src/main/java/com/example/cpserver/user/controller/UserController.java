package com.example.cpserver.user.controller;

import com.example.cpserver.user.controller.dto.GetUserDto;
import com.example.cpserver.user.repo.UserRepo;
import com.example.cpserver.general.dto.Message;
import com.example.cpserver.user.model.User;
import com.example.cpserver.user.model.UserRole;
import com.example.cpserver.cf.service.CfService;
import com.example.cpserver.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CfService cfService;
    private final UserService userService;
    private final UserRepo userRepo;

    @Autowired
    public UserController(CfService cfService, UserService userService, UserRepo userRepo) {
        this.cfService = cfService;
        this.userService = userService;
        this.userRepo = userRepo;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(
            @RequestParam (required = false) UserRole role
    ){
        if(role ==  null){
            return userRepo.findAll();
        }else if(role.equals(UserRole.USER)){
            return userRepo.findAllByRole(UserRole.USER);

        }else if(role.equals(UserRole.ADMIN)) {
            return userRepo.findAllByRole(UserRole.ADMIN);
        }else {
            return null;
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetUserDto getUser(
            @RequestParam ("id") Integer id
    ){
        return userService.getUser(id);
    }

    @GetMapping("/parse-user")
    public Message parseAttemptsUser(){
        cfService.parseUser();
        return new Message("Парсинг запущен");
    }

}
