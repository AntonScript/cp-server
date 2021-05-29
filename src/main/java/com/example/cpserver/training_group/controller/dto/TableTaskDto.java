package com.example.cpserver.training_group.controller.dto;

import com.example.cpserver.task.model.Task;

public class TableTaskDto {

    private Long id;
    private String name;
    private String link;
    private Long number;
    private Long first_key;
    private String second_key;

    public TableTaskDto() {
    }

    public TableTaskDto(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.link = task.getLink();
        this.number = task.getNumber();
        this.first_key = task.getFirst_key();
        this.second_key = task.getSecond_key();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getFirst_key() {
        return first_key;
    }

    public void setFirst_key(Long first_key) {
        this.first_key = first_key;
    }

    public String getSecond_key() {
        return second_key;
    }

    public void setSecond_key(String second_key) {
        this.second_key = second_key;
    }
}
