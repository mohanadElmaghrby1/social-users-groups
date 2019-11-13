package com.idealwaves.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * create by mohannad on 11/11/2019
 */
@Entity
@Table(name = "group_")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    @Size(min = 3, max = 15)
    private String name;

    @Column(nullable=false)
    private char isActive;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    Set<UserGroup> userGroups;

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

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
