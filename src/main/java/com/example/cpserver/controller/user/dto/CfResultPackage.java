package com.example.cpserver.controller.user.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class CfResultPackage implements Serializable {
    private Long id;
    private Long contestId;
    private CfProblem problem;
    private String verdict;
    private String programmingLanguage;

    public CfResultPackage() {
    }





    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }


    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }


    public CfProblem getProblem() {
        return problem;
    }

    public void setProblem(CfProblem problem) {
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

}
