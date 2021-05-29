package com.example.cpserver.training_group.controller.dto;

import com.example.cpserver.user.model.Attempt;

public class TableAttemptDto {
    private Long contestId;

    private String index;

    private Integer numberOfAttempts;

    private Boolean result;

    private String language;

    public TableAttemptDto() {
    }

    public TableAttemptDto(Attempt attempt) {
        this.contestId = attempt.getContestId();
        this.index = attempt.getIndex();
        this.numberOfAttempts = attempt.getNumberOfAttempts();
        this.result = attempt.getResult();
        this.language = attempt.getLanguage();
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
