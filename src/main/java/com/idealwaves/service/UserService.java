package com.idealwaves.service;

import com.idealwaves.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findById(long id);
    List<User> findAll();
    void delete(User user);
    void deleteById(long id);
}
