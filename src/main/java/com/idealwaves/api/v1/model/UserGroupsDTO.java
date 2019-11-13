package com.idealwaves.api.v1.model;

import com.idealwaves.domain.Group;
import com.idealwaves.domain.User;

import java.util.List;

/**
 * create by mohannad on 11/12/2019
 */
public class UserGroupsDTO {
    private User user;
    private List<Group> groups;

    public UserGroupsDTO(User user, List<Group> groups) {
        this.user = user;
        this.groups = groups;
    }

//    public UserGroupsDTO() {
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
