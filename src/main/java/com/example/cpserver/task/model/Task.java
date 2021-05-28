package com.example.cpserver.task.model;

import com.example.cpserver.theme.model.Theme;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;

    private Long number;

    private Long first_key;
    private String second_key;

    @JsonIgnore
    @ManyToOne
    private Theme theme;

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
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
