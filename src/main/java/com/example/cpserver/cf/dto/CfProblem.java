package com.example.cpserver.cf.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.io.Serializable;


public class CfProblem implements Serializable {
    private Long contestId;
    private String index;
    private String name;
    private String type;
    private Long rating;


    public CfProblem() {
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }
}
