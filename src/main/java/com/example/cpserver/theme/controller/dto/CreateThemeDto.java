package com.example.cpserver.theme.controller.dto;

public class CreateThemeDto {

    private String  name;

    public CreateThemeDto() {
    }

    public CreateThemeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
