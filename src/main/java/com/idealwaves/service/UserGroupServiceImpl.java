package com.idealwaves.service;

import com.idealwaves.domain.User;
import com.idealwaves.domain.UserGroup;
import com.idealwaves.repository.UserGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * create by mohannad on 11/12/2019
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {

    private UserGroupRepository userGroupRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public UserGroup save(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public Optional<UserGroup> findById(long id) {
        return userGroupRepository.findById(id);
    }

    @Override
    public List<UserGroup> findAll() {
        return userGroupRepository.findAll();
    }

    @Override
    public List<UserGroup> findAllUserGroups(User user) {
        return userGroupRepository.findByUser(user);
    }

    @Override
    public List<UserGroup> findAllUserGroupsByUserId(long userId) {
        return userGroupRepository.findByUserId(userId);
    }

    @Override
    public Optional<UserGroup> findByUserIdAndGroupId(long userID, long groupId) {
        return userGroupRepository.findByUserIdAndGroupId(userID,groupId);
    }

    @Override
    public void delete(UserGroup userGroup) {
        userGroupRepository.delete(userGroup);
    }

    @Override
    public void deleteById(long id) {
        userGroupRepository.deleteById(id);
    }

    @Override
    public void removeUserFromGroup(long userId, long groupId) {
        userGroupRepository.deleteByUserIdAndGroupId(userId,groupId);
    }
}
