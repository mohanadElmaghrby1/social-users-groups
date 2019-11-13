package com.idealwaves.api.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * create by mohannad on 11/13/2019
 */
public class GroupDTO {

    private long id;
    private String name;
    private char isActive;
    private LocalDateTime createdDate;

    public GroupDTO(long id, String name, char isActive, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
