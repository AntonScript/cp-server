package com.example.cpserver.user.controller.dto;

import com.example.cpserver.user.model.User;
import com.example.cpserver.user.model.UserRole;

import java.util.Map;

public class GetUserDto {
    private Integer id;

    private String login;


    private String email;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String handle;

    private UserRole role;

    private Map<Long,String> group;

    public GetUserDto() {
    }

    public GetUserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.patronymic = user.getPatronymic();
        this.handle = user.getHandle();
        this.role = user.getRole();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Map<Long, String> getGroup() {
        return group;
    }

    public void setGroup(Map<Long, String> group) {
        this.group = group;
    }
}
