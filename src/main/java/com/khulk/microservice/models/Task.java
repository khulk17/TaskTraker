package com.khulk.microservice.models;

import java.util.Random;

public class Task {
    private static int idno=-1;
    private int id;
    private String description;
    private Status status;
    private long createdAt;
    private long updatedAt;

    public Task(String description, Status status) {
        this.description = description;
        this.status = status;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = createdAt;
        this.id = idno;
        idno++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
