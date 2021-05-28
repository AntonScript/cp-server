package com.example.cpserver.user.model;

public enum UserRole {
    USER(0),
    TEACHER(1),
    ADMIN(2);

    private int id; // Could be other data type besides int
    UserRole(int id) {
        this.id = id;
    }
    public int getIdRole(){
        return id;
    }
}
