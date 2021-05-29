package com.example.cpserver.training_group.controller.dto;

import org.springframework.beans.factory.ListableBeanFactory;

import java.util.List;

public class TableUserDto {
    private Integer id;

    private String login;

    private String firstName;

    private String lastName;

    private String patronymic;

    private List<TableAttemptDto> listAttempt;

    public TableUserDto() {
    }

    public TableUserDto(Integer id, String login, String firstName, String lastName, String patronymic, List<TableAttemptDto> listAttempt) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.listAttempt = listAttempt;
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

    public List<TableAttemptDto> getListAttempt() {
        return listAttempt;
    }

    public void setListAttempt(List<TableAttemptDto> listAttempt) {
        this.listAttempt = listAttempt;
    }
}
