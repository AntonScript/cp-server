package com.example.cpserver.user.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthUserDto {
    @Size(min = 1, max = 50)
    @NotNull
    public String login;

    @Size(min = 1, max = 50)
    @NotNull
    public String password;
}
