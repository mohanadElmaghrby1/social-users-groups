package com.idealwaves.repository;

import com.idealwaves.domain.User;
import com.idealwaves.domain.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository extends JpaRepository<UserGroup , Long> {
    List<UserGroup> findByUser(User user);
    List<UserGroup> findByUserId(long userId);
    Optional<UserGroup> findByUserIdAndGroupId(long userID , long groupId);
    void deleteByUserIdAndGroupId(long userID , long groupId);
}
