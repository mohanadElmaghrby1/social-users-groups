package com.idealwaves.repository;

import com.idealwaves.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by mohannad on 11/11/2019
 */
public interface UserRepository  extends JpaRepository<User , Long> {
}
