package com.example.cpserver.training_group.controller.dto;

import java.util.List;

public class TableThemeDto {
    private String name;
    private List<TableTaskDto> listTask;
    private List<TableUserDto> listUser;

    public TableThemeDto() {
    }

    public TableThemeDto(String name, List<TableTaskDto> listTask) {
        this.name = name;
        this.listTask = listTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableTaskDto> getListTask() {
        return listTask;
    }

    public void setListTask(List<TableTaskDto> listTask) {
        this.listTask = listTask;
    }

    public List<TableUserDto> getListUser() {
        return listUser;
    }

    public void setListUser(List<TableUserDto> listUser) {
        this.listUser = listUser;
    }
}
