package com.example.cpserver.task.controller.dto;

public class CreateTaskDto {
    private Long idTheme;
    private String  name;
    private String link;

    public CreateTaskDto() {
    }

    public Long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Long idTheme) {
        this.idTheme = idTheme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
