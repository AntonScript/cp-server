package com.example.cpserver.training_group.controller.dto;

import java.util.List;

public class TableGroupDto {
    private Long id;
    private String name;
    private List<TableThemeDto> listTheme;

    public TableGroupDto() {
    }

    public TableGroupDto(Long id, List<TableThemeDto> listTheme) {
        this.id = id;
        this.listTheme = listTheme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TableThemeDto> getListTheme() {
        return listTheme;
    }

    public void setListTheme(List<TableThemeDto> listTheme) {
        this.listTheme = listTheme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
