package com.idealwaves.service;

import com.idealwaves.domain.User;
import com.idealwaves.domain.UserGroup;

import java.util.List;
import java.util.Optional;

public interface UserGroupService {
    UserGroup save(UserGroup userGroup);
    Optional<UserGroup> findById(long id);
    List<UserGroup> findAll();
    List<UserGroup> findAllUserGroups(User user);
    List<UserGroup> findAllUserGroupsByUserId(long userId);
    Optional<UserGroup> findByUserIdAndGroupId(long userID , long groupId);
    void delete(UserGroup userGroup);
    void deleteById(long id);
    void removeUserFromGroup(long userId, long groupId);
}
