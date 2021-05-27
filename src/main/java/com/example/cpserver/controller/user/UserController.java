package com.example.cpserver.controller.user;

import com.example.cpserver.Repo.UserRepo;
import com.example.cpserver.controller.dto.Message;
import com.example.cpserver.model.User;
import com.example.cpserver.model.UserRole;
import com.example.cpserver.service.cf.CfService;
import com.example.cpserver.service.user.UserService;
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
    ){
        return userRepo.findAllByRole(UserRole.USER);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public User getUser(
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
