package com.idealwaves.service;

import com.idealwaves.domain.Group;

import java.util.List;
import java.util.Optional;

/**
 * create by mohannad on 11/12/2019
 */
public interface GroupService {
    Group save(Group group);
    Optional<Group> findById(long id);
    List<Group> findAll();
    void delete(Group group);
    void deleteById(long id);
}
