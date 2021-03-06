package com.example.cpserver.user.model;

import com.example.cpserver.user.controller.dto.RegUserDto;
import com.example.cpserver.training_group.model.TrainingGroup;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String handle;

    private UserRole role;

    private Long lastIdAttempt = 0L;


    @JsonProperty("trainingGroupIds")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @ManyToMany
    private Set<TrainingGroup> trainingGroups;


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Attempt> attempts;


    public User() {
    }



    public User(RegUserDto userDto) {
        this.login = userDto.login;
        this.password = userDto.password;
        this.email = userDto.email;
        this.firstName = userDto.firstName;
        this.lastName = userDto.lastName;
        this.patronymic = userDto.patronymic;
        this.handle = userDto.handle;
        this.role = userDto.role;
    }


    public Set<TrainingGroup> getTrainingGroups() {
        return trainingGroups;
    }

    public void setTrainingGroups(Set<TrainingGroup> trainingGroups) {
        this.trainingGroups = trainingGroups;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(Set<Attempt> attempts) {
        this.attempts = attempts;
    }


    public Long getLastIdAttempt() {
        return lastIdAttempt;
    }

    public void setLastIdAttempt(Long lastIdAttempt) {
        this.lastIdAttempt = lastIdAttempt;
    }
}
