package com.example.cpserver.user.controller.dto;

import com.example.cpserver.user.model.UserRole;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegUserDto {
    @Size(min = 1, max = 50)
    @NotNull
    public String login;

    @Size(min = 1, max = 50)
    @NotNull
    public String password;

    @Size(min = 1, max = 50)
    @NotNull
    public String email;

    @Size(min = 1, max = 50)
    @NotNull
    public String firstName;

    @Size(min = 1, max = 50)
    @NotNull
    public String lastName;

    @Size(min = 1, max = 50)
    @NotNull
    public String patronymic;

    @Size(min = 1, max = 50)
    public String handle;

    @NotNull
    public  UserRole role;
}
