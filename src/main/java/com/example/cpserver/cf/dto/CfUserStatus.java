package com.example.cpserver.cf.dto;

import java.io.Serializable;
import java.util.List;


public class CfUserStatus implements Serializable {
    private String status;
    private List<CfResultPackage> result;

    public CfUserStatus() {
    }

    public CfUserStatus(String status, List<CfResultPackage> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CfResultPackage> getResult() {
        return result;
    }

    public void setResult(List<CfResultPackage> result) {
        this.result = result;
    }
}
