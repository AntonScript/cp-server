package com.example.cpserver.training_group.controller.dto;

import java.util.Set;

public class UpdateGroupDto {
    private Long id;
        private Set<Integer> addUsers;
    private Set<Integer> deleteUsers;
    private Set<Long> addTheme;
    private Set<Long> deleteTheme;

    public UpdateGroupDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Integer> getAddUsers() {
        return addUsers;
    }

    public void setAddUsers(Set<Integer> addUsers) {
        this.addUsers = addUsers;
    }

    public Set<Integer> getDeleteUsers() {
        return deleteUsers;
    }

    public void setDeleteUsers(Set<Integer> deleteUsers) {
        this.deleteUsers = deleteUsers;
    }

    public Set<Long> getAddTheme() {
        return addTheme;
    }

    public void setAddTheme(Set<Long> addTheme) {
        this.addTheme = addTheme;
    }

    public Set<Long> getDeleteTheme() {
        return deleteTheme;
    }

    public void setDeleteTheme(Set<Long> deleteTheme) {
        this.deleteTheme = deleteTheme;
    }
}
