package com.example.cpserver.controller.user.dto;

import com.example.cpserver.model.UserRole;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

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
