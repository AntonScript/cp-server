package com.example.cpserver.training_group.controller.dto;

public class CreateGroupDto {
    private String name;

    public CreateGroupDto(String name) {
        this.name = name;
    }

    public CreateGroupDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
